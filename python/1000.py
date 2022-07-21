from typing import List


class Solution:
    def mergeStones(self, stones: List[int], k: int) -> int:
        # 4 -> 1 4 7
        # 5 -> 1 5 9
        n = len(stones)
        if n == 1:
            return 0
        if (n - 1) % (k - 1) != 0:
            return -1

        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + stones[i]

        dp = [[1e8 for _ in range(n)] for _ in range(n)]
        # K -> K+n*(K-1)
        for i in range(n):
            if i + k - 1 >= n:
                continue
            dp[i][i + k - 1] = prefix[i + k] - prefix[i]
        for i in range(2 * k - 1, n + 1):
            for j in range(n):  # l
                r = j + i - 1
                if r >= n:
                    break
                # 段与段合并
                for k1 in range(j + 1, r):
                    dp[j][r] = min(dp[j][r], prefix[r + 1] - prefix[j] + dp[j][k1] + dp[k1 + 1][r])
                # 元素与段合并
                delta = i - (k - 1)
                for st in range(j, j + i):  # inclusive
                    ed = st + delta - 1
                    if ed >= n:
                        break
                    dp[j][r] = min(dp[j][r], prefix[r + 1] - prefix[j] + dp[st][ed])

        return dp[0][-1]


s = Solution()
print(s.mergeStones([3, 2, 4, 1], 2))
print(s.mergeStones([3, 5, 1, 2, 6], 3))
