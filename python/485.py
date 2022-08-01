from typing import List


class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        ans = 0
        n = 0
        for num in nums:
            if num == 1:
                n += 1
                ans = max(ans, n)
            else:
                n = 0
        return ans

