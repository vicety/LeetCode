package com.company.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P264_2 {
    class Number {
        int val;
        int prime;
        int index;

        public Number(int val, int prime, int index) {
            this.val = val;
            this.prime = prime;
            this.index = index;
        }
    }

    public int nthUglyNumber(int n) {
        int[] primes = new int[]{2, 3, 5};
        Queue<Number> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.val));
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new Number(primes[i], primes[i], 0));
        }
        int cnt = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        while (cnt != n) {
            Number now = pq.poll();
            dp[cnt++] = now.val;
            pq.offer(new Number(dp[now.index] * now.prime, now.prime, now.index + 1));
            while (pq.peek().val == now.val) {
                Number tmp = pq.poll();
                pq.offer(new Number(dp[tmp.index] * tmp.prime, tmp.prime, tmp.index + 1));
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        P264_2 p264_2 = new P264_2();
        System.out.println(p264_2.nthUglyNumber(12));
    }
}
