class Solution:
    def longestValidParentheses(self, s: str) -> int:
        dp = [0] * (len(s) + 1)
        for i, c in enumerate(s):
            if c == ")":
                if i > 0 and s[i - 1] == "(":
                    dp[i] = dp[i - 2] + 1
                elif dp[i - 1] != 0:
                    prev = i - 1 - 2 * dp[i - 1]
                    if prev >= 0 and s[i - 1 - 2 * dp[i - 1]] == "(":
                        dp[i] = dp[i - 1] + 1
                        if prev - 1 >= 0:
                            dp[i] += dp[prev - 1]
        return max(dp) * 2


s = Solution()
print(s.longestValidParentheses("(()"))
print(s.longestValidParentheses(")()())"))
print(s.longestValidParentheses(")(()()))(())"))
print(s.longestValidParentheses("(())()"))
print(s.longestValidParentheses(""))
