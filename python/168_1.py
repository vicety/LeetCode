class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        now_cycle = 26
        n = 1

        while columnNumber > now_cycle:
            columnNumber -= now_cycle
            now_cycle *= 26
            n += 1

        return self.solve(columnNumber, now_cycle, n)

    def solve(self, num, cycle, n):
        num -= 1
        ans = ""
        while n > 0:
            cycle //= 26
            div = num // cycle
            ans = ans + chr(ord("A") + div)
            num %= cycle
            n -= 1
        return ans


s = Solution()
print(s.convertToTitle(27))
print(s.convertToTitle(701))
print(s.convertToTitle(2147483647))
