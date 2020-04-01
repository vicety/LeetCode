package com.company.leetCode;

import java.util.Arrays;

public class P238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int now = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] *= now;
            now *= nums[i];
        }
        now = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= now;
            now *= nums[i];
        }
        return ans;
    }
}
