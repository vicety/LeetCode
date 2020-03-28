package com.company.leetCode;

public class P209 {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int nowSum = 0;
        for (int i = 0; i < nums.length; i++) {
            nowSum += nums[r++];
            if (nowSum >= s) {
                while(nowSum >= s) {
                    ans = Math.min(ans, r - l);
                    nowSum -= nums[l++];
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
