from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        s = 0
        for num in nums:
            s += num
        if s % 2 != 0:
            return False
        dst = s // 2
        dp = [0] * (dst + 1)
        dp[0] = 1
        for num in nums:
            for i in range(dst, 0, -1):
                if i - num >= 0 and dp[i - num] != 0:
                    dp[i] = 1

        return dp[dst] == 1


s = Solution()
print(s.canPartition([1, 2, 5]))
