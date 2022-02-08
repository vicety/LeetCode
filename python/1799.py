from functools import reduce
from typing import List, Set


class Solution:
    def maxScore(self, nums: List[int]) -> int:
        nums.sort()
        combination = []
        self.dfs(0, nums, set(), [], combination)
        # print(combination)
        result = -1
        for comb in combination:
            comb.sort()
            i = 1
            now = 0
            for num in comb:
                now += i * num
                i += 1
            if now > result:
                result = now

        return result

    def dfs(self, now: int, nums: List[int], vis: Set[int], current: List[int], results: List[List[int]]):
        if now in vis:
            return self.dfs(now + 1, nums, vis, current, results)
        if now == len(nums):
            results.append(current.copy())
            return
        for i in range(now + 1, len(nums)):
            if i in vis:
                continue
            current.append(self.gcd(nums[i], nums[now]))
            # print(now, i)
            vis.add(i)
            self.dfs(now + 1, nums, vis, current, results)
            vis.remove(i)
            current.pop()

    def gcd(self, a, b):
        if a % b == 0:
            return b
        return self.gcd(b, a % b)


s = Solution()
# print(s.gcd(8, 4))
# print(s.maxScore([1, 2, 3, 4, 5, 6]))
print(s.maxScore([697035, 181412, 384958, 575458]))
