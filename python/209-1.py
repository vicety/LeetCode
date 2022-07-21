from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        prefix = dict()
        prefix[0] = -1
        now = 0
        ans = 1e8
        for i, num in enumerate(nums):
            # now - x = target -> x = now - target
            now += num
            if prefix.get(now - target) is not None:
                ans = min(ans, i - prefix[now - target])
            prefix[now] = i
        if ans == 1e8:
            return 0
        else:
            return ans
