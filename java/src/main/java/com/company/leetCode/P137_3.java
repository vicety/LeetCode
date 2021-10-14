package com.company.leetCode;

public class P137_3 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int cnt = 0;
            for(int num : nums) {
                if(((num >> i) & 1) == 1) cnt++;
            }
            if(cnt % 3 == 1) ans += (1 << i);
        }
        return ans;
    }
}
