package com.company.leetCode;

public class P213 {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) ans = Math.max(ans, nums[i]);
            return ans;
        }
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[1] = nums[1];
        for(int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        for(int i = 2; i < nums.length; i++) dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }
}
