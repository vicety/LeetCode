package com.company.leetCode;

public class P371 {
    public int getSum(int a, int b) {
        if(b == 0) return a;
        return getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        int a = -1;
        System.out.println(~(a - 1));
    }
}
