package com.company.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P26 {
    public int removeDuplicates(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int now = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!st.contains(nums[i])){
                nums[now++] = nums[i];
                st.add(nums[i]);
            }
        }
        return now;
    }
}
