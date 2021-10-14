package com.company.leetCode;

public class P188 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) return 0;
//        if(k > prices.length) k = prices.length / 2;
        if(k > prices.length) {
            int ans = 0;
            for(int i = 1; i < prices.length; ++i){
                if(prices[i] > prices[i - 1])
                    ans += prices[i] - prices[i - 1];
            }
            return ans;
        }
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int prep = -prices[0];
            // j = 0 -> dp[i][0] = 0
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prep + prices[j]);
                prep = Math.max(prep, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }
}
