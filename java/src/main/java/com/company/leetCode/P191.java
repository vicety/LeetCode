package com.company.leetCode;

import java.util.Collections;
import java.util.LinkedList;

public class P191 {
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) cnt++;
            n >>= 1;
        }
        return cnt;
//        Collections.shuffle();
//        (new LinkedList<>()).get()
//        Integer
    }
}
