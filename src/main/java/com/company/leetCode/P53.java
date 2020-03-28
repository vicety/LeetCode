package com.company.leetCode;

public class P53 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int now = 0;
        for(int i = 0;i < nums.length; i++) {
            now += nums[i];
            ans = Math.max(ans, now);
            if(now < 0) now = 0;
        }
        return ans;
    }
}
