package com.company.leetCode;

public class P34 {

    private int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(nums[mid] >= target) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    private int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(nums[mid] <= target) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }

    private int binary(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if(binary(nums, target) == -1) return new int[]{-1, -1};
        return new int[]{findLeft(nums, target), findRight(nums, target)};
    }
}
