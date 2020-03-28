package com.company.leetCode;

public class P169 {
    public int majorityElement(int[] nums) {
        Integer acc = null;
        int cnt = 0;
        for (int num : nums) {
            if(acc == null) {
                acc = num;
                cnt = 1;
            }
            else {
                if(num == acc) cnt++;
                else {
                    cnt--;
                    if(cnt == 0) acc = null;
                }
            }
        }
        return acc;
    }
}
