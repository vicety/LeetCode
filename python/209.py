from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        prefix = [0]
        for num in nums:
            prefix.append(prefix[-1] + num)
        stack = [(0, 0)]  # val, index | increasing
        MAX = 99999999
        ans = MAX
        for idx, pref in enumerate(prefix):
            if idx == 0:
                continue
            # pref - prefix[i] >= target
            #  -> prefix[i] <= pref - target
            targetNow = pref - target
            res = self.findFirstLEQ(stack, targetNow, 0, len(stack) - 1)
            stackVal, stackIdx = stack[res]
            if stackVal <= targetNow:
                ans = min(ans, idx - stackIdx)
            while stack and stack[-1][0] >= pref:
                stack.pop()
            stack.append((pref, idx))
        return 0 if ans == MAX else ans

    def findFirstLEQ(self, srtd, target, l, r):
        while l <= r:
            mid = (l + r) // 2
            val, _ = srtd[mid]
            if val <= target:
                l = mid + 1
            else:
                r = mid - 1
        return r


s = Solution()
print(s.minSubArrayLen(7, [2, 3, 1, 2, 4, 3]))
print(s.minSubArrayLen(4, [1, 4, 4]))
print(s.minSubArrayLen(11, [1, 1, 1, 1, 1, 1, 1, 1]))
