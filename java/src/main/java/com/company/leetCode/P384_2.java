package com.company.leetCode;

import java.util.Random;

public class P384_2 {
    class Solution {

        private int[] origin;
        private int[] nums;
        private Random random = new Random();

        public Solution(int[] nums) {
            this.origin = nums.clone();
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            nums = origin.clone();
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = nums.length; i > 1; i--) {
                int now = random.nextInt(i);
                swap(nums, now, i - 1);
            }
            return nums;
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
