package com.company.leetCode;

public class P50 {
    public double myPow(double x, int n) {
        if(n == 0) return 1;

        double ans = 1;
        double mul = n > 0 ? x : 1 / x;
        long nn = Math.abs((long) n);

        while(nn > 0) {
            if((nn & 1) == 1) ans *= mul;
            nn >>= 1;
            mul = mul * mul;
        }
        return ans;
    }

    public static void main(String[] args) {
        P50 p50 = new P50();
        System.out.print(p50.myPow(2, -2147483648));
    }
}
