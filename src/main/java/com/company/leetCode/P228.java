package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 1) {
            ans.add(nums[0] + "");
            return ans;
        }
        boolean inRange = false;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (nums[i] == nums[i - 1] + 1) {
                    ans.add(String.format("%d->%d", start, nums[i]));
                } else {
                    if (inRange) ans.add(String.format("%d->%d", start, nums[i - 1]));
                    ans.add(nums[i] + "");
                }
            } else {
                if (nums[i] == nums[i + 1] - 1) {
                    if (!inRange) {
                        inRange = true;
                        start = nums[i];
                    }
                } else {
                    if (inRange) {
                        ans.add(String.format("%d->%d", start, nums[i]));
                        inRange = false;
                    } else ans.add(nums[i] + "");
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P228 p228 = new P228();
        System.out.println(p228.summaryRanges(new int[]{}));
    }
}
