class Solution:
    def longestPalindrome(self, s: str) -> str:
        maxSt = -1
        maxEd = -1
        isPalindrome = [[0 for _ in range(len(s))] for _ in range(len(s))]
        for i in range(len(s)):
            isPalindrome[i][i] = 1
            maxSt = i
            maxEd = i
        for i in range(len(s) - 1):
            if s[i] == s[i + 1]:
                isPalindrome[i][i + 1] = 1
                maxSt = i
                maxEd = i + 1
        for k in range(2, len(s)):
            for i in range(len(s)):
                st = i
                ed = i + k
                if ed >= len(s):
                    break
                if isPalindrome[st + 1][ed - 1] and s[st] == s[ed]:
                    isPalindrome[st][ed] = 1
                    maxSt = st
                    maxEd = ed
        return s[maxSt:maxEd + 1]


s = Solution()
print(s.longestPalindrome("babad"))
print(s.longestPalindrome("cbbd"))
