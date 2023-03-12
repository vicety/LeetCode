from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        sz = len(prices)
        dp = [[0 for _ in range(sz)] for _ in range(sz)]
        