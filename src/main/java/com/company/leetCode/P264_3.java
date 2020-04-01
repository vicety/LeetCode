package com.company.leetCode;

public class P264_3 {
    public int nthUglyNumber(int n) {
        int[] primes = new int[]{2, 3, 5};
        int[] pointers = new int[3];
        int[] dp = new int[n];
        int[] tmp = new int[3];
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
