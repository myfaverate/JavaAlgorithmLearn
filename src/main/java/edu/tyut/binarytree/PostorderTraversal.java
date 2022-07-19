package edu.tyut.binarytree;

import com.sun.source.tree.Tree;

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
        List<Integer> list = postorderTraversal(treeNode1);
        System.out.println(list);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        // TODO 未完成，后序遍历非递归
        var arr = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            if(root.right!=null){
                stack.add(root.right);
            }
            if(root.left!=null){
                stack.add(root.left);
            }
            root = stack.peek();
            if(root.left==null&&root.right==null){
                root=stack.pop();
                arr.add(root.val);
            } else if (root.right!=null) {
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
