from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last = {}
        for i in range(len(s) - 1, -1, -1):
            c = s[i]
            if last.get(c) is None:
                last[c] = i
        st = 0
        j = 0
        ans = []
        while True:
            last_occur = -1
            while True:
                c = s[j]
                last_occur = max(last_occur, last[c])
                j += 1
                if j > last_occur:
                    ans.append(j - st)
                    st = j
                    if j >= len(s):
                        return ans
                    break

s = Solution()
print(s.partitionLabels("ababcbacadefegdehijhklij"))
