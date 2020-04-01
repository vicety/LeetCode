package com.company.leetCode;

public class P390 {
    public int lastRemaining(int n) {
        int first = 1, gap = 1;
        boolean leftToRight = true;
        while (n > 1) {
            if (leftToRight) {
                first += gap;
                gap *= 2;
                n -= (n + 1) / 2;
                leftToRight = false;
            } else {
                if (n % 2 == 1) {
                    first += gap;
                    gap *= 2;
                    n -= (n + 1) / 2;
                } else {
                    n /= 2;
                    gap *= 2;
                }
                leftToRight = true;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        P390 p390 = new P390();
        System.out.println(p390.lastRemaining(9));
    }
}
