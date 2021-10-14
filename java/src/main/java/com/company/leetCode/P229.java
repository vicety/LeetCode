package com.company.leetCode;

import java.util.List;

public class P229 {
    public List<Integer> majorityElement(int[] nums) {
        Integer k1 = null, v1 = 0, k2 = null, v2 = 0;
        for(int num :nums) {
            if(v1 == 0) {
                k1 = num;
                v1 = 1;
            } else {
                if(k1 == num) v1++;
                else v1--;
            }
            if(v2 == 0) {
                k2 = num;
                v2 = 1;
            } else {
                if(k2 == num) v2++;
                else v2--;
            }
        }
        return null;
    }
}
