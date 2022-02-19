from typing import List


class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        di = {}
        for num in nums:
            if len(di) == 0:
                di[num] = 1
                di[-num] = 1
            else:
                new_di = {}
                for k, v in di.items():
                    new_di[k + num] = new_di.get(k + num, 0) + v
                    new_di[k - num] = new_di.get(k - num, 0) + v
                di = new_di
        return di.get(target, 0)


s = Solution()
print(s.findTargetSumWays([1, 1, 1, 1, 1], 3))
