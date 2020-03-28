package com.company.leetCode;

public class P97_3 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= s1.length(); i++)
            if (dp[i - 1][0] == 1 && s1.charAt(i - 1) == s3.charAt(i - 1))
                dp[i][0] = 1;
        for (int i = 1; i <= s2.length(); i++)
            if (dp[0][i - 1] == 1 && s2.charAt(i - 1) == s3.charAt(i - 1))
                dp[0][i] = 1;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if((s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j] == 1)
                 || s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j  - 1] == 1)
                    dp[i][j] = 1;
            }
        }
        return dp[s1.length()][s2.length()] == 1;
    }

    public static void main(String[] args) {
        P97_3 p97_3 = new P97_3();
        System.out.println(p97_3.isInterleave("", "b", "b"));
    }
}
