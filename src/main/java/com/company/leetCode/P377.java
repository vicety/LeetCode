package com.company.leetCode;

import java.util.Arrays;
import java.util.Map;

public class P377 {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 0;
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > i) break;
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
