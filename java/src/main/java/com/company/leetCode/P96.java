package com.company.leetCode;

public class P96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int mid = 1; mid <= i; mid++) {
                dp[i] += dp[mid - 1] * dp[i - mid];
            }
        }
        return dp[n];
    }
}
