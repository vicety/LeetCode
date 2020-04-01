package com.company.leetCode;

public class P303 {
    class NumArray {

        int[] prefix;

        public NumArray(int[] nums) {

            prefix = new int[nums.length];
            if (nums.length == 0) return;
            prefix[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefix[i] = nums[i] + prefix[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
        }
    }
}
