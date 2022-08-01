class Solution:
    def findSubstringInWraproundString(self, p: str) -> int:
        maxSuffix = dict()
        ans = 0
        nowC = "^"
        nowLen = 0
        for c in p:
            # 如果initial nowC = "" -> if (not nowC or c == self.nextC(nowC))
            if c == self.nextC(nowC):
                nowLen += 1
            else:
                nowLen = 1
            nowC = c

            if maxSuffix.get(c, 0) < nowLen:
                ans += nowLen - maxSuffix.get(c, 0)
                maxSuffix[c] = nowLen

        return ans

    # 也可以 (new-old) % 26 == 1
    def nextC(self, c):
        if c == 'z':
            return 'a'
        return chr(ord(c) + 1)


s = Solution()
print(s.findSubstringInWraproundString("abacdeade"))
