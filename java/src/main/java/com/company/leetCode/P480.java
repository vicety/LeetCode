package com.company.leetCode;

import java.util.*;

public class P480 {
    public static void main(String[] args) {
        P480.Solution s = new Solution();
        System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1)));
//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(1);
//        set.add(3);
//        set.add(2);
//        System.out.println(set.first());
//        System.out.println(set.last());
    }

    static class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            Comparator<Integer> comparator = (a, b) -> {
                if (nums[a] != nums[b]) {
                    return Integer.compare(nums[a], nums[b]);
                }
                return Integer.compare(a, b);
            };
            TreeSet<Integer> lo = new TreeSet<>(comparator);
            TreeSet<Integer> hi = new TreeSet<>(comparator);

            double[] ans = new double[nums.length - k + 1];
            int p = 0;
            for (int i = 0; i < k; i++) {
                hi.add(i);
            }
            while (hi.size() > lo.size() + 1) lo.add(hi.pollFirst()); // lo add hi min
            ans[p++] = getMid(nums, hi, lo);

            for (int i = k; i < nums.length; i++) {
                if (!lo.remove(i - k)) {
                    hi.remove(i - k);
                }

                hi.add(i);
                lo.add(hi.pollFirst());
//                while (hi.size() > lo.size() + 1) lo.add(hi.pollFirst());
                while (lo.size() > hi.size()) hi.add(lo.pollLast());
                ans[p++] = getMid(nums, hi, lo);
            }

            return ans;
        }

        private double getMid(int[] nums, TreeSet<Integer> hi, TreeSet<Integer> lo) {
            if (lo.size() == hi.size()) return ((double) nums[lo.last()] + nums[hi.first()]) / 2;
            return nums[hi.first()];
        }
    }
}

