package com.company.leetCode;

public class P33_2 {
    private int solve(int[] nums, int target, int l, int r) {
        System.out.println(String.format("%d %d", l, r));
        if (l > r) return -1;
        int mid = (l + r) >> 1;
        if (target == nums[mid]) return mid;
        if ((target >= nums[l] && target <= nums[mid])
                || (target >= nums[mid] && target <= nums[r])) {
            while (l <= r) {
                System.out.println(String.format("%d %d", l, r));
                if (target == nums[mid]) return mid;
                else if (target > nums[mid]) l = mid + 1;
                else r = mid - 1;
                mid = (l + r) >> 1;
            }
            return -1;
        } else {
            if (nums[mid] > nums[r]) return solve(nums, target, mid + 1, r);
            else return solve(nums, target, l, mid - 1);
        }
    }

    public int search(int[] nums, int target) {
        return solve(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println((new P33_2()).search(new int[]{3,5,1}, 3));
    }
}
