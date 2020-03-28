package com.company.leetCode;

public class P198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < 2; i++) {
            if (i < nums.length) {
                if (i == 0) dp[i] = nums[i];
                else dp[i] = Math.max(nums[0], nums[1]);
            }
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        P198 p198 = new P198();
        System.out.println(p198.rob(new int[]{1, 2}));
    }
}
