from typing import List


class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        usingNOnes = [0] * (k + 1)
        for item in nums:
            if item == 1:
