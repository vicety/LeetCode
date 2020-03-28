package com.company.leetCode;

public class P376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int ans = 1;
        int now = nums[0];
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] == now) i++;
            else if (nums[i + 1] > now) {
                while (i < nums.length - 1 && nums[i + 1] >= nums[i]) i++;
                now = nums[i];
                ans++;
            } else {
                while (i < nums.length - 1 && nums[i + 1] <= nums[i]) i++;
                now = nums[i];
                ans++;
            }
        }
        return ans;
    }
}
