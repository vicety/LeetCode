package com.company.leetCode;

import java.util.*;

public class P313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Arrays.sort(primes);
        Queue<Long> queue = new PriorityQueue<>(Comparator.comparingLong(i -> i));
        Set<Long> inQueue = new HashSet<>();
        queue.offer((long) 1);
        inQueue.add((long) 1);
        int now = 1;
        while (n != now) {
            now++;
            long val = queue.poll();
            for (int i = 0; i < primes.length; i++) {
                long toPut = val * primes[i];
                if (inQueue.contains(toPut)) continue;
                inQueue.add(toPut);
                queue.offer(toPut);
            }
        }
        return queue.peek().intValue();
    }

    public static void main(String[] args) {
        P313 p313 = new P313();
        System.out.println(p313.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
