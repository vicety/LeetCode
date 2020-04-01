package com.company.leetCode;

import java.util.Random;

public class P384 {
    class Solution {

        private int[] index;
        private int[] nums;
        private Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
            this.index = new int[nums.length];
            for (int i = 0; i < nums.length; i++) index[i] = i;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            int[] ans = new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                ans[index[i]] = nums[i];
                index[i] = i;
            }
            nums = ans;
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = nums.length; i > 1; i--) {
                int now = random.nextInt(i);
                swap(nums, now, i - 1);
                swap(index, now, i - 1);
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
