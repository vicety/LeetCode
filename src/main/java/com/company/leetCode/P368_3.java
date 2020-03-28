package com.company.leetCode;

import java.util.*;

public class P368_3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }
        int tail = -1;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > len) {
                tail = i;
                len = dp[i];
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (tail != -1) {
            ans.add(nums[tail]);
            tail = prev[tail];
        }
        return ans;
    }

    public static void main(String[] args) {
        P368_3 p368_3 = new P368_3();
        System.out.println(p368_3.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        System.out.println(p368_3.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(p368_3.largestDivisibleSubset(new int[]{2, 3, 4, 8}));
    }
}
