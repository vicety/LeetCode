package com.company.leetCode;

public class P115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for(int i = 0; i <= s.length(); i++) dp[0][i] = 1;
        for(int i = 1; i <= t.length(); i++) {
            for(int j = 1; j <= s.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if(t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        P115 p115 = new P115();
        System.out.println(p115.numDistinct("rabbbit", "rabbit"));
    }
}
