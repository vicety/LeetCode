package com.company.leetCode;

import java.util.Arrays;

public class P16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minAbs = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int st = i + 1;
            int ed = nums.length - 1;
            while (st < ed) {
                int all = nums[i] + nums[st] + nums[ed];
                int abs;
                if(all > target) abs = Math.min(minAbs, all - target);
                else abs = Math.min(minAbs, target - all);
                if(abs < minAbs) {
                    ans = all;
                    minAbs = abs;
                }
                if(all == target) return target;
                else if(all > target) ed--;
                else st++;
            }
        }
        return ans;
    }
}
