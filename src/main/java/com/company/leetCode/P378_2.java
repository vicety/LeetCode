package com.company.leetCode;

import java.util.*;

public class P378_2 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(0)));
        Set<Integer> vis = new HashSet<>();
        queue.offer(Arrays.asList(matrix[0][0], 0, 0));
        vis.add(0);
        int now = 0;
        int ans = -1, y, x;
        while (now < k) {
            List<Integer> tmp = queue.poll();
            ans = tmp.get(0);
            y = tmp.get(1);
            x = tmp.get(2);
            int right = serialize(y, x + 1, n);
            if (x < n - 1 && !vis.contains(right)) {
                vis.add(right);
                queue.offer(Arrays.asList(matrix[y][x + 1], y, x + 1));
            }
            int down = serialize(y + 1, x, n);
            if (y < m - 1 && !vis.contains(down)) {
                vis.add(down);
                queue.offer(Arrays.asList(matrix[y + 1][x], y + 1, x));
            }
            now++;
        }
        return ans;
    }

    private int serialize(int y, int x, int n) {
        return y * n + x;
    }
}
