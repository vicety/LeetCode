class Solution:
    def longestPalindrome(self, s: str) -> str:
        ans = s[0]
        maxLen = 1
        for i in range(len(s)):
            for k in range(1, len(s)):
                l = i - k
                r = i + k
                if l < 0 or r >= len(s):
                    break
                if s[l] != s[r]:
                    break
                if (r - l + 1) > maxLen:
                    maxLen = r - l + 1
                    ans = s[l:r + 1]

        for i in range(len(s)):
            for k in range(len(s)):
                l = i - k
                r = i + 1 + k
                if l < 0 or r >= len(s):
                    break
                if s[l] != s[r]:
                    break
                if (r - l + 1) > maxLen:
                    maxLen = r - l + 1
                    ans = s[l:r + 1]

        return ans


s = Solution()
print(s.longestPalindrome("babad"))
print(s.longestPalindrome("cbbd"))
