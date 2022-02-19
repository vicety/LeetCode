from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix = [0]
        ans = 0
        for num in nums:
            prefix.append(prefix[-1] + num)
        for i in range(1, len(nums)+1):
            for j in range(i):
                if prefix[i] - prefix[j] == k:
                    ans += 1
        return ans