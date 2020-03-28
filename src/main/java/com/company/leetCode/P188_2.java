package com.company.leetCode;

public class P188_2 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        if (k >= prices.length) {
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
            }
            return ans;
        }
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int acc = Integer.MIN_VALUE;
            for (int j = 1; j < prices.length; j++) {
                acc = Math.max(acc, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], acc + prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }
}
