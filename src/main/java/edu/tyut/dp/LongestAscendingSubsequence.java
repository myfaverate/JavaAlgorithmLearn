package edu.tyut.dp;


public class LongestAscendingSubsequence {
    // 力扣300 最长上升子序列
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(f(array, array.length-1));
    }
    public static int f(int[] nums,int i){
        int a=1;
        for (int j = 0; j < i; j++) {
            if (nums[j]<nums[i]){
                a = Math.max(a,f(nums,j)+1);
            }
        }
        return a;
    }
}
