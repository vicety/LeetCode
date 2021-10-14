package com.company.leetCode;

public class P343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
            if(i == n) return dp[n];
            dp[i] = Math.max(dp[i], i);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println((new P343()).integerBreak(2));
    }
}
