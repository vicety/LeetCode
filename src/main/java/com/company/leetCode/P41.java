package com.company.leetCode;

public class P41 {

    private void dfs(int[] nums, int now, boolean first) {
        if (nums[now] == now + 1) return;
        else {
            int tmp = nums[now];
            if (!first) nums[now] = now + 1;
            if (tmp > 0 && tmp < nums.length) {
                dfs(nums, tmp - 1, false);
            }
        }
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, true);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
