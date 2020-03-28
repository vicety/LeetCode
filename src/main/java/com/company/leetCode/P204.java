package com.company.leetCode;

import java.util.Arrays;

public class P204 {
    public int countPrimes(int n) {
        if (n < 3) return 0;  // 题目定义是不包括n
        int[] prime = new int[n];
        int cnt = 0;
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        for (long i = 2; i < n; i++) {
            if (prime[(int) i] == 1) {
                // primes[cnt++] = i; // to record each prime
                cnt++;
//                if(i > 46340) continue; // sqrt(2 << 31 - 1) = 46340.9
                for (long j = i * i; j < n; j += i) {
                    prime[(int) j] = 0;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        P204 p204 = new P204();
        System.out.println(p204.countPrimes(2));
    }
}
