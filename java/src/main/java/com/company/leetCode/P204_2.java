package com.company.leetCode;

import java.util.Arrays;

public class P204_2 {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        long[] prime = new long[n];
        long[] primes = new long[n];
        int cnt = 0;
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        for (long i = 2; i < n; i++) {
            if (prime[(int) i] == 1) {
                primes[cnt++] = i;
            }
            for (long j = 0; i * primes[(int) j] < n && j < primes.length; j++) {
                prime[(int) (i * primes[(int) j])] = 0;
                if(i % primes[(int) j] == 0) break;
            }
        }
        return cnt;
    }
}
