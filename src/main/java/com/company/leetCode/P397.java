package com.company.leetCode;

import java.util.*;

public class P397 {
    public int integerReplacement(int n) {
        Set<Integer> possiblePaths = new HashSet<>();
        generatePossiblePaths(possiblePaths, n);
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        vis.add(1);
        int batch = 0;
        while (!queue.isEmpty()) {
            List<Integer> nextBatch = new ArrayList<>();
            while (!queue.isEmpty()) {
                int now = queue.poll();
                if (now == n) return batch;
                if (now % 2 == 0) {
                    if(possiblePaths.contains(now + 1) && !vis.contains(now + 1)) {
                        nextBatch.add(now + 1);
                        vis.add(now + 1);
                    }
                    if(possiblePaths.contains(now - 1) && !vis.contains(now - 1)) {
                        nextBatch.add(now - 1);
                        vis.add(now - 1);
                    }
                }
                if(possiblePaths.contains(now * 2) && !vis.contains(now * 2)) {
                    nextBatch.add(now * 2);
                    vis.add(now * 2);
                }
            }
            queue.addAll(nextBatch);
            batch++;
        }
        return -1;
    }

    private void generatePossiblePaths(Set<Integer> paths, int n) {
        if (paths.contains(n)) return;
        paths.add(n);
        if (n == 1) return;
        if (n % 2 == 1) {
            generatePossiblePaths(paths, n - 1);
            generatePossiblePaths(paths, n + 1);
        } else generatePossiblePaths(paths, n / 2);
    }

    public static void main(String[] args) {
        P397 p397 = new P397();
        System.out.println(p397.integerReplacement(1));
    }
}
