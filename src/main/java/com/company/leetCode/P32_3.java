package com.company.leetCode;

public class P32_3 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') dp[i] = 1;
        }
        for (int i = 3; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (dp[i] != 0 && i - dp[i] - 1 >= 0 && dp[i - dp[i] - 1] != 0) dp[i] = dp[i] + dp[i - dp[i] - 1] + 1;
                else if (dp[i] == 0 && dp[i - 1] != 0 && i - 1 - dp[i - 1] - 1 >= 0 &&
                        s.charAt(i - 1 - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i] - 1 >= 0 && dp[i - dp[i] - 1] != 0) dp[i] += dp[i - dp[i] - 1] + 1;
                }
            }
        }
        int ans = 0;
        for (int i : dp) {
            if (i > ans) ans = i;
        }
        return ans == 0 ? 0 : ans + 1;
    }

    public static void main(String[] args) {
        System.out.println((new P32_3()).longestValidParentheses("((()))())"));
    }
}
