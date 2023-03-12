class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        # A-Z 26
        # AA - ZZ 26 * 26
        columnNumber -= 1
        nowMax = 26
        sz = 1
        while columnNumber >= nowMax:
            columnNumber -= nowMax
            sz += 1
            nowMax *= 26
        nowMax //= 26
        ans = ""
        for _ in range(sz):
            n = columnNumber // nowMax
            # print(columnNumber, n, nowMax)
            ans += chr(ord('A') + n)
            columnNumber = columnNumber % nowMax
            nowMax //= 26
        return ans


s = Solution()
print(s.convertToTitle(701))
