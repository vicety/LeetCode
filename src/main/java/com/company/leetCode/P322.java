package com.company.leetCode;

import java.util.Arrays;

public class P322 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount) dp[coins[i]] = 1;
        }
        for (int i = 1; i < amount; i++) {
            if (dp[i] != 0) {
                for (int j = 0; j < coins.length; j++) {
                    if(coins[j] > amount || i + coins[j] > amount) continue;
                    if (dp[i + coins[j]] == 0) dp[i + coins[j]] = dp[i] + 1;
                    else dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        P322 p322 = new P322();
        System.out.println(p322.coinChange(new int[]{1, Integer.MAX_VALUE}, 2));
    }
}
