from typing import List


class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        nStr = len(strs)
        items = []
        for s in strs:
            n0, n1 = 0, 0
            for c in s:
                if c == '0':
                    n0 += 1
                elif c == '1':
                    n1 += 1
            items.append((n0, n1))

        dp = [[[0 for _ in range(n + 1)] for _ in range(m + 1)] for _ in range(nStr + 1)]
        for i in range(1, nStr + 1):
            n0, n1 = items[i - 1]
            for j in range(m + 1):
                for k in range(n + 1):
                    if n0 <= j and n1 <= k:
                        dp[i][j][k] = max(dp[i - 1][j][k], dp[i - 1][j - n0][k - n1] + 1)
                        # print(i - 1, j, k, dp[i - 1][j][k])
                    else:
                        dp[i][j][k] = dp[i - 1][j][k]

        return dp[nStr][m][n]


s = Solution()
print(s.findMaxForm(["10", "0001", "111001", "1", "0"], 5, 3))
print(s.findMaxForm(["10", "0", "1"], 1, 1))
print(s.findMaxForm(["00101011"], 36, 39))
