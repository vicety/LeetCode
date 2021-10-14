package com.company.leetCode;

public class P201 {
    public int rangeBitwiseAnd(int m, int n) {
        int now = 0;
        int weight = 1;
        while (m != 0 && n != 0) {
            if(n == m && (n & 1) == 1) now += weight;
            weight <<= 1;
            m >>= 1;
            n >>= 1;
        }
        return now;
    }
}
