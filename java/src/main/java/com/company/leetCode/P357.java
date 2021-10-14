package com.company.leetCode;

public class P357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) n = 10;
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 10;
        int now = 2;
        while (now <= n) {
            int tmp = 9;
            int mul = 9;
            int cnt = now - 1;
            while (cnt-- != 0) {
                tmp *= mul;
                mul--;
            }
            dp[now] = dp[now - 1] + tmp;
            now++;
        }
        return dp[n];
    }
}
