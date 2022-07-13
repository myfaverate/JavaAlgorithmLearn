package edu.tyut.dp;

public class Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if(nums==null||nums.length==0) return 0;
        int[][] dp = new int[len][2];
        // 定义边界
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<len;i++){
            // 递推公式
            // 1,2,3,3
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            // dp[i][0] = dp[i-1][1]; // 这是错误的
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{1,2,2,3}));
    }
}
