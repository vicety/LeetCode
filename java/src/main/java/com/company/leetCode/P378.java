package com.company.leetCode;

import java.util.*;

public class P378 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(0)));
        for (int i = 0; i < m; i++) {
            queue.add(Arrays.asList(matrix[i][0], i, 0));
        }
        int now = 0;
        int ans = -1;
        while (now < k) {
            List<Integer> list = queue.poll();
            int val = list.get(0), line = list.get(1), index = list.get(2);
            ans = val;
            if (index < n - 1) queue.offer(Arrays.asList(matrix[line][index + 1], line, index + 1));
            now++;
        }
        return ans;
    }
}
