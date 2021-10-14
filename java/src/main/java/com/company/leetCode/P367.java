package com.company.leetCode;

public class P367 {
//    public boolean isPerfectSquare(int num) {
//        long now = 1;
//        long tmp = now * now;
//        while(tmp <= num) {
//            if(tmp == num) return true;
//            now += 1;
//            tmp = now * now;
//        }
//        return false;
//    }

    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int tmp = num / mid;
            if (tmp < mid) r = mid - 1;
            else if (tmp > mid) l = mid + 1;
            else return num % tmp == 0;
        }
        return false;
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
