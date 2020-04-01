package com.company.leetCode;

import java.util.*;

public class P373_2 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(0)));
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) return ans;
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.offer(Arrays.asList(nums1[i] + nums2[0], i, 0));
        }
        while (!queue.isEmpty() && ans.size() < k) {
            List<Integer> now = queue.poll();
            int val = now.get(0), index1 = now.get(1), index2 = now.get(2);
            if (index2 < nums2.length - 1)
                queue.offer(Arrays.asList(nums1[index1] + nums2[index2 + 1], index1, index2 + 1));
            ans.add(Arrays.asList(nums1[index1], nums2[index2]));
        }
        return ans;
    }
}
