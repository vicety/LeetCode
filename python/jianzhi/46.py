class Solution:
    def translateNum(self, num: int) -> int:
        s = str(num)
        st = set()
        self.dfs(s, 0, "", st)
        return len(st)

    def dfs(self, s, i, cur, ans):
        if i == len(s):
            ans.add(cur)
            return

        self.dfs(s, i + 1, cur + self.toChar(int(s[i])), ans)
        if s[i] != '0' and i + 1 < len(s) and int(s[i:i + 2]) < 26:
            self.dfs(s, i + 2, cur + self.toChar(int(s[i:i + 2])), ans)

    def toChar(self, i):
        return chr(ord('a') + i)


s = Solution()
print(s.translateNum(506))
