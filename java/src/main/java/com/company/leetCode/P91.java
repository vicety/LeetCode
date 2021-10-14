package com.company.leetCode;

public class P91 {
    private int getOne(char c) {
        return (int) c - (int) '0';
    }

    private int getTwo(char a, char b) {
        return getOne(a) * 10 + getOne(b);
    }

    private boolean validOne(char c) {
        return getOne(c) > 0;
    }

    private boolean validTwo(char a, char b) {
        return getOne(a) != 0 && getTwo(a, b) > 0 && getTwo(a, b) < 27;
    }

    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return validOne(s.charAt(0)) ? 1 : 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = validOne(s.charAt(0)) ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            if (dp[i - 2] != 0 && validTwo(s.charAt(i - 2), s.charAt(i - 1))) dp[i] += dp[i - 2];
            if(dp[i - 1] != 0 && validOne(s.charAt(i - 1))) dp[i] += dp[i - 1];
        }

        return dp[s.length()];
    }
}
