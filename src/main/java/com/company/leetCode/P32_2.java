package com.company.leetCode;

public class P32_2 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') dp[i] = 1;
        }
        for (int inc = 3; inc < s.length(); inc += 2) {
            for (int st = 0; st + inc < s.length(); st++) {
                int ed = st + inc;
                if (s.charAt(st) == '(' && s.charAt(ed) == ')'
                        && ((dp[st] != 0 && st + dp[st] + 1 + dp[st + dp[st] + 1] == ed)
                        || st + 1 + dp[st + 1] == ed - 1)) dp[st] = ed - st;
            }
        }
        int ans = 0;
        for (int i : dp) {
            if(i > ans) ans = i;
        }
        return ans == 0 ? 0 : ans + 1;
    }

    public static void main(String[] args) {
        System.out.println((new P32_2()).longestValidParentheses(")(()())()(())"));
    }
}
