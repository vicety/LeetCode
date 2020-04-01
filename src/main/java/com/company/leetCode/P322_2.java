package com.company.leetCode;

import java.util.Arrays;

public class P322_2 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int ans = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            ans += amount / coins[i];
            amount = amount % coins[i];
        }
        if(amount != 0) return -1;
        return ans;
    }
}
