package com.company.leetCode;

import java.sql.SQLOutput;

public class P342 {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        int max = (int) Math.pow(4, Math.floor(Math.log(Integer.MAX_VALUE) / Math.log(4)));
        return max % num == 0;
    }

    public static void main(String[] args) {
        System.out.println((int) Math.pow(4, Math.floor(Math.log(Integer.MAX_VALUE) / Math.log(4))));
    }
}
