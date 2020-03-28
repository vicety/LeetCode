package com.company.leetCode;

public class P81_2 {
    private int findDiff(int[] nums, int target) {
        int st = 0;
        int ed = nums.length - 2;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (nums[mid] > nums[mid + 1]) return mid;
//            else if()
        }
        return -1;
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return true;
    }
}
