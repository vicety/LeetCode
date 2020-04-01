package com.company.leetCode;

public class P81 {
    private boolean solve(int[] nums, int target, int l, int r) {
        System.out.println(String.format("%d %d", l, r));
        if (l > r) return false;
        while(l < r) {
            if(nums[l] == nums[r]) {
                if(target == nums[l]) return true;
                l++;
                r--;
            }
            else break;
        }
        int mid = (l + r) >> 1;
        if (target == nums[mid]) return true;
        if ((target >= nums[l] && target <= nums[mid])
                || (target >= nums[mid] && target <= nums[r])) {
            while (l <= r) {
                if (target == nums[mid]) return true;
                else if (target > nums[mid]) l = mid + 1;
                else r = mid - 1;
                mid = (l + r) >> 1;
            }
            return false;
        } else {
            if (nums[mid] > nums[r]) return solve(nums, target, mid + 1, r);
            else return solve(nums, target, l, mid - 1);
        }
    }

    public boolean search(int[] nums, int target) {
        return solve(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        P81 p81 = new P81();
        System.out.println(p81.search(new int[]{1,1,3,1}, 3));
    }
}
