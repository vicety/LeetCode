from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        for c in s:
            if ord(c) > ord('9') or ord(c) < ord('0'):
                return []
        ans = []
        self.dfs(s, 0, [], ans)
        return ans

    def dfs(self, s, i, cur, ans):
        if i == len(s):
            if len(cur) != 4:
                return
            else:
                ans.append(".".join(cur))
                return
        if len(cur) == 4 and i != len(s):
            return
        if s[i] == '0':
            if i + 1 <= len(s) and int(s[i:i + 1]) <= 255:
                self.dfs(s, i + 1, cur + [s[i:i + 1]], ans)
        else:
            for j in range(3):
                if i + 1 + j <= len(s) and int(s[i:i + 1 + j]) <= 255:
                    self.dfs(s, i + 1 + j, cur + [s[i:i + 1 + j]], ans)


s = Solution()
print(s.restoreIpAddresses("25525511135"))
print(s.restoreIpAddresses("0000"))
print(s.restoreIpAddresses("01010"))
print(s.restoreIpAddresses("101023"))
