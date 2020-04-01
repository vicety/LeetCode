package com.company.leetCode;

public class P189 {
    public void rotate(int[] nums, int k) {
        if (nums == null) return;
        k %= nums.length;
        int start = 0, nxt, cur = nums[0], curIndex = 0, nxtIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            curIndex = nxtIndex;
            nxtIndex = (curIndex + k) % nums.length;
            nxt = nums[nxtIndex];
            nums[nxtIndex] = cur;
            cur = nxt;
            if (nxtIndex == start) {
                nxtIndex = ++start;
                cur = nums[start];
            }
        }
    }
}
