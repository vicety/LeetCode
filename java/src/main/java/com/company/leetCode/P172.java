package com.company.leetCode;

import com.company.jianzhi.P1;

public class P172 {
    public int trailingZeroes(int n) {
        int now = n;
        int five = 0;
        int two = 0;
//        int zero = 0;
        while(now > 0) {
            two += now / 2;
            now /= 2;
        }
        now = n;
        while(now > 0) {
            five += now / 5;
            now /= 5;
        }
//        now = n;
//        while(now > 0) {
//            zero += now / 10;
//            now /= 10;
//        }
        return Math.min(two, five);
    }

    public static void main(String[] args) {
        P172 p172 = new P172();
        System.out.println(p172.trailingZeroes(10));
    }
}
