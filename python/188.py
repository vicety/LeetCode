from typing import List


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        sz = len(prices)
        dp = [[[0 for _ in range(sz)] for _ in range(sz)] for _ in range(k)]
        st = 0

        # 

        while st < sz:
            cur_min = cur_max = prices[st]
            for ed in range(st, sz):
                cur_max = max(cur_max)