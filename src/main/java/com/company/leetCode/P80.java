package com.company.leetCode;

public class P80 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int now = nums[0];
        int cnt = 0;
        int cntAll = 0;
        int ptr = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != now) {
                now = nums[i];
                cnt = 1;
                cntAll++;
                nums[ptr++] = now;
            } else {
                if(cnt == 2) continue;
                cnt++;
                cntAll++;
                nums[ptr++] = now;
            }
        }
        return cntAll;
    }
}
