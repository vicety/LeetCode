package com.company.leetCode;

public class P27 {
    public int removeElement(int[] nums, int val) {
        int now = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[now++] = nums[i];
            }
        }
        return now;
    }
}
