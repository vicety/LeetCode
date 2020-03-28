package com.company.leetCode;

public class P33 {

    private int findSpecial(int[] nums) {
        int l = 0, r = nums.length - 1;
        if(nums[l] < nums[r]) return 0;
        while(l <= r) {
            int mid = (l + r) >> 1;
            // 如果比左边高，那么说明在右边，否则说明在左边n
            if(nums[mid] > nums[mid + 1]) return mid + 1;
            else if(nums[mid] >= nums[l]) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    private int convertToRotate(int n, int[] nums, int special) {
        int rightSize = nums.length - special;
        if(n < rightSize) return special + n;
        else return n - rightSize;
    }

    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) {
            if(nums[0] == target) return 0;
            else return -1;
        }
        int special = findSpecial(nums);
        System.out.println(String.format("Special is: %d", special));
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            int rotatedMid = convertToRotate(mid, nums, special);
            if(nums[rotatedMid] == target) return rotatedMid;
            else if(nums[rotatedMid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        P33 p33 = new P33();
        System.out.println(p33.search(new int[]{4, 5, 1, 2, 3}, 1));
    }

}
