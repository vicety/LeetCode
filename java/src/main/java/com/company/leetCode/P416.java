package com.company.leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author vicety
 * @date 2020/4/12 22:56
 */
public class P416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        set.add(0);
        for (int num : nums) {
            Queue<Integer> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int now = queue.poll();
                newQueue.offer(now);
                int to = now + num;
                if (set.contains(to)) continue;
                set.add(to);
                newQueue.offer(to);
            }
            queue = newQueue;
            if (set.contains(target)) return true;
        }
        return set.contains(target);
    }
}
