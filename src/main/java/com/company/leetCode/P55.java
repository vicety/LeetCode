package com.company.leetCode;

public class P55 {
    public boolean canJump(int[] nums) {
        int nowMax = 0;
        int last = -1;
        while (nowMax < nums.length - 1) {
            if (nowMax == last) break;
            int tmp = nowMax;
            for (int i = last + 1; i <= Math.min(nowMax, nums.length - 1); i++) {
                nowMax = Math.max(nowMax, i + nums[i]);
            }
            last = tmp;
        }
        return nowMax >= nums.length - 1;
    }
}
