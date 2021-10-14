package com.company.leetCode;

public class P313_2 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        int[] dp = new int[n];
        int[] tmp = new int[primes.length];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                tmp[j] = primes[j] * dp[pointers[j]];
                if (tmp[j] < min) min = tmp[j];
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (tmp[j] == min) pointers[j]++;
            }
        }
        return dp[n - 1];
    }
}
