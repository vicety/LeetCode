package com.company.leetCode;

public class P97_2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        System.out.println(s1.length() + 1);
        System.out.println(s2.length() + 1);
        dp[0][0] = 1;
        for (int i = 1; i <= s3.length(); i++) {
            for(int j = 0; j <= i; j++) {
                int s1Now = j; // 取s1Now个
                int s2Now = i - j;
                if(s1Now > s1.length() || s2Now > s2.length()) continue;
                if(s1Now != 0 && s1.charAt(s1Now - 1) == s3.charAt(i - 1) && dp[s1Now - 1][s2Now] == 1) dp[s1Now][s2Now] = 1;
                if(s2Now != 0 && s2.charAt(s2Now - 1) == s3.charAt(i - 1) && dp[s1Now][s2Now - 1] == 1) dp[s1Now][s2Now] = 1;
            }
        }
        return dp[s1.length()][s2.length()] == 1;
    }
}
