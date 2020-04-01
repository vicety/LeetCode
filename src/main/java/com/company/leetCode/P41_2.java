package com.company.leetCode;

public class P41_2 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int nxt = nums[i];
            while (nxt <= nums.length && nxt >= 1 && nums[nxt - 1] != nxt) {
                int tmp = nums[nxt - 1];
                nums[nxt - 1] = nxt;
                nxt = tmp;
            }
        }
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) ans++;
            else break;
        }
        return ans;
    }
}
