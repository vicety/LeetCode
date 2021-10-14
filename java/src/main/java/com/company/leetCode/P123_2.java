package com.company.leetCode;

public class P123_2 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int[][] dp = new int[3][prices.length];
        for (int i = 1; i <= 2; i++) {
            int tmp = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], tmp + prices[j]);
                tmp = Math.max(tmp, dp[i][j] - prices[j]);
            }
        }
        return dp[2][prices.length - 1];
    }
}
