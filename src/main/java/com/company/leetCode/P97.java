package com.company.leetCode;

public class P97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        // check final: dp[s1.length][s2.length][s3.length]
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for(int now = 1; now <= s3.length(); now++) {
            for (int i = 0; i <= now; i++) {
                int s1now = i;
                int s2now = now - s1now;
                if(s1now > s1.length() || s2now > s2.length()) continue;
                if(s1now != 0 && dp[s1now - 1][s2now] && s1.charAt(s1now - 1) == s3.charAt(now - 1)) dp[s1now][s2now] = true;
                if(s2now != 0 && dp[s1now][s2now - 1] && s2.charAt(s2now - 1) == s3.charAt(now - 1)) dp[s1now][s2now] = true;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
