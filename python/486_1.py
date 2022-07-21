from typing import List


class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        size = len(nums)
        # dp st ed (inclusive) who's-turn = score
        # index 1 based
        dp = [[[0, 0] for _ in range(size + 2)] for _ in range(size + 2)]
        for k in range(size):
            for st in range(1, size + 1):
                ed = st + k
                if ed > size:
                    break
                # TODO：根据数组长度判断是谁的回合
                dp[st][ed][0] = min(dp[st + 1][ed][1] - nums[st - 1], dp[st][ed - 1][1] - nums[ed - 1])
                dp[st][ed][1] = max(dp[st + 1][ed][0] + nums[st - 1], dp[st][ed - 1][0] + nums[ed - 1])

        # print(dp[1][size][0] == -dp[1][size][1]) # should be always true
        return dp[1][size][0] <= 0


s = Solution()
print(s.PredictTheWinner([1, 5, 233, 7]))
