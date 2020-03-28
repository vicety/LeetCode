package com.company.leetCode;

import java.util.Arrays;

public class P279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = 1;
            while (i >= tmp * tmp) {
                dp[i] = Math.min(dp[i], dp[i - tmp * tmp] + 1);
                tmp++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        P279 p279 = new P279();
        System.out.println(p279.numSquares(12));
    }
}
