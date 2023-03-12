from typing import List


class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        sz = len(nums)

        def isP1(n):
            return n % 2 == sz % 2

        dp = [[0 for _ in range(sz + 1)] for _ in range(sz + 1)]

        for k in range(0, sz):
            for st in range(sz):
                ed = st + k
                if ed >= sz:
                    break
                p1 = isP1(ed - st + 1)
                if p1:
                    dp[st][ed] = max(dp[st + 1][ed] + nums[st], dp[st][ed - 1] + nums[ed])
                else:
                    dp[st][ed] = min(dp[st + 1][ed] - nums[st], dp[st][ed - 1] - nums[ed])
        return dp[0][sz - 1] >= 0
