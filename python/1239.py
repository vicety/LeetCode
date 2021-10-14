from typing import List


class Solution:
    def maxLength(self, arr: List[str]) -> int:
        arrUniq = []
        for s in arr:
            if self.uniqStr(s):
                arrUniq.append(s)

        global ans
        ans = 0

        def solve(lst, cur, length, vis):
            global ans
            if cur == len(lst):
                ans = max(ans, length)
                return
            solve(lst, cur + 1, length, vis)

            curStr = lst[cur]
            if self.contradict(curStr, vis):
                return
            for c in curStr:
                vis.add(c)
            solve(lst, cur + 1, length + len(curStr), vis)
            for c in curStr:
                vis.remove(c)

        solve(arrUniq, 0, 0, set())

        return ans

    def contradict(self, s, st):
        for c in s:
            if c in st:
                return True
        return False

    def uniqStr(self, s):
        st = set()
        for c in s:
            if c in st:
                return False
            st.add(c)
        return True


S = Solution()
print(S.maxLength(["un", "iq", "ue"]))
print(S.maxLength(["cha","r","act","ers"]))
print(S.maxLength(["abcdefghijklmnopqrstuvwxyz"]))
print(S.maxLength(["aa","bb"]))
