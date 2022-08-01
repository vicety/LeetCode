class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        # TODO 下次最好把s p也垫一下，index都从1开始

        dp = [[0 for _ in range(len(s) + 1)] for _ in range(len(p) + 1)]
        dp[0][0] = 1

        ptrp = 0
        while ptrp < len(p):
            if p[ptrp] == '.':
                ptrp += 1
                token = "."
                if ptrp < len(p) and p[ptrp] == '*':
                    ptrp += 1
                    token = ".*"
            else:
                token = p[ptrp]
                ptrp += 1
                if ptrp < len(p) and p[ptrp] == '*':
                    ptrp += 1
                    token += "*"

            # p-index at dp equals ptrp now
            if token == ".":
                # i-index meaning s-index at dp before this new token
                for i in range(len(s)):
                    if dp[ptrp - 1][i]:
                        dp[ptrp][i + 1] = 1
            elif token == ".*":
                for i in range(len(s) + 1):
                    if dp[ptrp - 2][i]:
                        for j in range(i, len(s) + 1):
                            dp[ptrp][j] = 1
                        break
            elif len(token) == 2:  # "x*"
                letter = token[0]
                for i in range(len(s) + 1):
                    if dp[ptrp - 2][i]:
                        dp[ptrp][i] = 1
                        # notie i is prev at dp, but is now pos at s
                        for j in range(i, len(s)):
                            if s[j] == letter:
                                dp[ptrp][j + 1] = 1
                            else:
                                break
            else:
                for i in range(len(s)):
                    if dp[ptrp - 1][i] and s[i] == token:
                        dp[ptrp][i + 1] = 1

        return dp[len(p)][len(s)] == 1


s = Solution()
print(s.isMatch("aa", "a*"))
#
# print(s.isMatch("ab", "ab"))
# print(s.isMatch("", ""))
#
# print(s.isMatch("ab", ".*"))
# print(s.isMatch("", ".*"))
# print(s.isMatch("accb", "a.*b"))
# print(s.isMatch("abbc", "ab*c"))
#
# print(s.isMatch("ab", "a"))
# print(s.isMatch("aaaa", "a.*b"))
