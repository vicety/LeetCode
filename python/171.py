class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        ans = 0
        base = 1
        for c in columnTitle[::-1]:
            ans += base * (ord(c) - ord("A") + 1)
            base *= 26
        return ans

s = Solution()
print(s.titleToNumber("AB"))
