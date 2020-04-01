package com.company.leetCode;

public class P44 {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[p.length() + 1][s.length() + 1];
        dp[0][0] = 1;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '?') {
                // 从第一个真实字符开始
                for (int j = 0; j < s.length(); j++) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            } else if (p.charAt(i) == '*') {
                // 从空开始
                for(int j = 0; j <= s.length(); j++) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]); // 不匹配
                }
                // 从真实字符开始
                for(int j = 0; j < s.length(); j++) {
                    // 从*继续匹配得来或者从*第一次匹配开始
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i + 1][j]); // 继续上一个的匹配
                }
            }
            else {
                // 从真实字符开始
                for (int j = 0; j < s.length(); j++) {
                    if (p.charAt(i) == s.charAt(j)) dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[p.length()][s.length()] == 1;
    }

    public static void main(String[] args) {
        P44 p44 = new P44();
        System.out.println(p44.isMatch("adceb", "*a*b"));
    }
}
