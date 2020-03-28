package com.company.leetCode;

import java.util.Arrays;

public class P274 {
    public int hIndex(int[] citations) {
        int ans = 0;
        Arrays.sort(citations);
        for(int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] >= ans + 1) ans++;
        }
        return ans;
    }
}
