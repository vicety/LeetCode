package com.company.leetCode;

public class P309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int tmp = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) tmp = -prices[0];
            else if (i == 1) {
                dp[1] = Math.max(0, prices[i] + tmp);
                tmp = Math.max(tmp, -prices[1]);
            } else {
                // don't sell now or sell with the buying time satisfying the restriction
                dp[i] = Math.max(dp[i - 1], prices[i] + tmp);
                // must sell 3 days before, may buy one day before
                tmp = Math.max(tmp, dp[i - 2] - prices[i]);
            }
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        P309 p309 = new P309();
        System.out.println(p309.maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(p309.maxProfit(new int[]{2, 1, 4}));
    }
}
