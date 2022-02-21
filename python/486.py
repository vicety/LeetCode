from typing import List


class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [[[0 for _ in range(2)] for _ in range(n + 1)] for _ in range(n + 1)]
        # start(closed), end(open), if start from self
        for i in range(n + 1):
            dp[i][i][0] = 0
            dp[i][i][1] = 0
        for i in range(1, n + 1):  # seq len
            for j in range(n):  # start pos (closed)
                if (j + i) > n:  # end pos (open)
                    break
                dp[j][j + i][1] = max(dp[j + 1][j + i][0] + nums[j], dp[j][j + i - 1][0] + nums[j + i - 1])
                if dp[j + 1][j + i][0] + nums[j] > dp[j][j + i - 1][0] + nums[j + i - 1]: # if rival think taking left better, then we are left with left used state
                    dp[j][j + i][0] = dp[j + 1][j + i][1]
                else: # else we are equal to the state where right is used
                    dp[j][j + i][0] = dp[j][j + i - 1][1]

        return dp[0][n][1] >= dp[0][n][0]


s = Solution()
print(s.PredictTheWinner([1, 5, 2]))
print(s.PredictTheWinner([1, 5, 233, 7]))
