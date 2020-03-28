package com.company.leetCode;

public class P231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n != 1) {
            if((n & 1) == 1) return false;
            n >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        P231 p231 = new P231();
        System.out.println(p231.isPowerOfTwo(218));
    }
}
