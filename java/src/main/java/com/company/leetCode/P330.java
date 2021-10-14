package com.company.leetCode;

import java.util.Arrays;

public class P330 {
    public int minPatches(int[] nums, int n) {
        long complete = 0;
        int ans = 0;
//        Arrays.sort(nums);
        int pNums = 0;
        while (complete < n) {
            if (pNums < nums.length && nums[pNums] <= complete + 1) complete = complete + nums[pNums++];
            else {
                ans++;
                complete += complete + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P330 p330 = new P330();
        System.out.println(p330.minPatches(new int[]{1, 3}, 6));
    }
}
