package com.company.concurrent;

public class P10 {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[p.length() + 1][s.length() + 1];
        dp[0][0] = 1;
        int i = 1; // 当前为i，访问字符串-1
        while (i <= p.length()) {
            if (i != p.length() && p.charAt(i) == '*') {
                for (int j = 0; j <= s.length(); j++) {
                    if (dp[i - 1][j] == 1) dp[i + 1][j] = 1;
                    if (j > 0 && dp[i + 1][j - 1] == 1 &&
                            (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.'))
                        dp[i + 1][j] = 1;
                }
                i += 2;
            } else {
                for (int j = 1; j <= s.length(); j++) {
                    if (p.charAt(i - 1) == '.' || s.charAt(j - 1) == p.charAt(i - 1)) dp[i][j] = dp[i - 1][j - 1];
                }
                i++;
            }
        }
        return dp[p.length()][s.length()] == 1;
    }
}
