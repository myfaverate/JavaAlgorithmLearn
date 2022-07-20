package edu.tyut.binarytree;

import java.util.*;

public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode4.left = treeNode7;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode5.right = treeNode8;

//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode1.right = treeNode2;
//        treeNode2.left = treeNode3;
        List<Integer> list = postorderTraversalMorrisSelf(treeNode1);
        System.out.println(list);
    }

    public static List<Integer> postorderTraversalMorrisSelf(TreeNode root) {
        /*
            2. 如果当前节点的左子节点为空，则遍历当前节点的右子节点；
            3. 如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点；
            (1).如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点，当前节点更新为当前节点的左子节点。
            (2).如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。倒序输出从当前节点的左子节点到该前驱节点这条路径上的所有节点。
            当前节点更新为当前节点的右子节点。
            // 此处需要把链表反转，然后再次反转恢复
        */
        // TODO 有空闲时间来解决此问题（已完成）
        TreeNode cur = root;
        TreeNode prev = null;
        var arr = new ArrayList<Integer>();
        while (cur!=null){
            prev=cur.left;
            if(prev!=null){
                // 前驱节点已找到
                while (prev.right!=null&&prev.right!=cur){
                    prev=prev.right;
                }
                if (prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                    continue;
                }else {
                    prev.right=null;
                    myAddPath(arr,cur.left);
                }
            }
            cur=cur.right;
        }
        myAddPath(arr,root);
        return arr;
    }

    public static void myAddPath(List<Integer> arr,TreeNode treeNode){
        int count=0;
        while (treeNode!=null){
            count++;
            arr.add(treeNode.val);
            treeNode=treeNode.right;
        }
        // 倒叙
        int left = arr.size()-count;
        int right = arr.size()-1;
        int tmp;
        while (left<right){
            tmp=arr.get(left);
            arr.set(left,arr.get(right));
            arr.set(right,tmp);
            left++;
            right--;
        }
    }

    public static List<Integer> postorderTraversalMorris(TreeNode root) {
        /*
            2. 如果当前节点的左子节点为空，则遍历当前节点的右子节点；
            3. 如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点；
            (1).如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点，当前节点更新为当前节点的左子节点。
            (2).如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。倒序输出从当前节点的左子节点到该前驱节点这条路径上的所有节点。
            当前节点更新为当前节点的右子节点。
        */
        // TODO 有空闲时间来解决此问题
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode cur = root, prev = null;
        // 当前节点不为空，继续遍历
        while (cur != null) {
            prev = cur.left; // 前驱节点指向当前节点的左节点
            if (prev != null) { // 当当前节点的左节点不为空时
                // 当前节点的左节点不为空时且 当前节点的左节点的右节点不指向当前节点时，当前节点的左节点的右节点为当前节点的前驱节点
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                // 当前节点的左节点的右节点不为空时，当前节点的左节点的右节点指向当前节点，当前节点指向当前节点的的左子节点
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                    continue; // 避免执行下面那条语句 cur = cur.right;
                } else {
                    prev.right = null; // 如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。
                    addPath(res, cur.left);
                }
            }
            cur = cur.right;
        }
        addPath(res, root); // 最后把树的 1 3 6 添加并反转
        return res;
    }

    public static void addPath(List<Integer> res, TreeNode node) {
        int count = 0; //
        while (node != null) {
            ++count;
            res.add(node.val);
            node = node.right;
        }
        // 逆序翻转
        int left = res.size() - count, right = res.size() - 1;
        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }

    public static List<Integer> postorderTraversalIteration(TreeNode root) {
        // TODO 已经完成，后序遍历非递归
        var arr = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();
        var pre = new TreeNode();
        while (root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.add(root);
                root=root.left;
            }
            root = stack.pop();
            if(root.right==null||root.right==pre){
                arr.add(root.val);
                pre=root;
                root=null;
            }else {
                stack.add(root);
                root=root.right;
            }
        }
        return arr;
    }

    // 在根节点后加空节点做标识
    public static List<Integer> postorderTraversalTwoStackReverseNullMark(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root != null) {
                stack.push(root);
                stack.push(null);
                if (root.right != null)
                    stack.push(root.right);
                if (root.left != null)
                    stack.push(root.left);
            } else
                res.add(stack.pop().val);
        }
        return res;
    }

    public static List<Integer> postorderTraversalTwoStackReverse(TreeNode root) {

        // 非递归 单栈+反转
        var arr = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            arr.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(arr);
        return arr;
    }

    public static List<Integer> postorderTraversalTwoStack(TreeNode root) {

        // 非递归 双栈
        var arr = new ArrayList<Integer>();
        var stack1 = new Stack<TreeNode>();
        var stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode p = stack1.pop();
            stack2.push(p);
            if (p.left != null) {
                stack1.push(p.left);
            }
            if (p.right != null) {
                stack1.push(p.right);
            }
        }
        while (!stack2.isEmpty()) {
            arr.add(stack2.pop().val);
        }
        return arr;
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
