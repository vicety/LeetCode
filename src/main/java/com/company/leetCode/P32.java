package com.company.leetCode;

public class P32 {
    // DP有两种扩展方法 ()+() or ()套()
    public int longestValidParentheses(String s) {
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                dp[i][i + 1] = true;
                ans = Math.max(ans, 2);
            }
        }
        for (int i = 3; i <= s.length() - 1; i += 2) {
            for (int j = 0; j + i < s.length(); j++) {
                boolean cond1 = dp[j + 1][j + i - 1] && s.charAt(j) == '(' && s.charAt(i + j) == ')';
                boolean cond2 = dp[j][j + i - 2] && s.charAt(j + i - 1) == '(' && s.charAt(j + i) == ')';
                boolean cond3 = dp[j + 2][j + i] && s.charAt(j) == '(' && s.charAt(j + 1) == ')';
                dp[j][j + i] = cond1 || cond2 || cond3;
                if(dp[j][j + i]) {
                    System.out.println(String.format("%d %d", j, j + i));
                    ans = Math.max(ans, i + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(0 | 1 | 0);
        P32 p32 = new P32();
        System.out.println(p32.longestValidParentheses(")(((((()())()()))()(()))("));
    }
}
