package com.company.leetCode;

import java.util.*;

public class P398 {
    class Solution {

        Map<Integer, List<Integer>> toIndex = new HashMap<>();
        Random random = new Random();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                toIndex.computeIfAbsent(num, k -> new ArrayList<>());
                toIndex.get(num).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> indexes = toIndex.get(target);
            return indexes.get(random.nextInt(indexes.size()));
        }
    }
}
