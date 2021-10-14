package com.company.leetCode;

public class P287_3 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int slow = nums[nums.length - 1];
        int fast = nums[nums.length - 1];
        do {
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
        } while (slow != fast);
        // System.out.println(slow);
        int another = nums[nums.length - 1];
        while (another != fast) {
            another = nums[another - 1];
            fast = nums[nums[fast - 1] - 1];
        }
        return another;
    }
}
