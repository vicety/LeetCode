package com.company.leetCode;

public class P268_2 {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) ans = ans ^i ^ nums[i];
        ans ^= nums.length;
        return ans;
    }
}
