from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [-1] * (amount + 1)
        dp[0] = 0
        for coin_val in coins:
            max_coin = amount // coin_val
            for base in range(amount + 1):
                if dp[base] == -1:
                    continue
                for i in range(1, max_coin + 1):
                    if base + coin_val * i > amount:
                        break
                    if dp[base + coin_val * i] == -1:
                        dp[base + coin_val * i] = dp[base] + i
                    else:
                        dp[base + coin_val * i] = min(dp[base + coin_val * i], dp[base] + i)

        return dp[amount]
