from functools import lru_cache
from typing import List, Set, Dict, Tuple


class Solution:
    def maxScore(self, nums: List[int]) -> int:
        nums.sort()
        result = [-1]
        self.dfs(0, nums, set(), [], result, {})
        # print(combination)

        return result[0]

    def dfs(self, now: int, nums: List[int], vis: Set[int], current: List[List[int]], result: List[int],
            cache: Dict[Tuple, int]):
        if now in vis:
            self.dfs(now + 1, nums, vis, current, result, cache)
            return
        if now == len(nums):
            # print(current)
            gcds = []
            for a, b in current:
                gcd = cache.get((a, b))
                if gcd is not None:
                    gcds.append(gcd)
                else:
                    tmp = self.gcd(nums[a], nums[b])
                    gcds.append(tmp)
                    cache[(a, b)] = tmp

            gcds.sort()
            ans = 0
            i = 1
            for gcd in gcds:
                ans += i * gcd
                i += 1
            if ans > result[0]:
                result[0] = ans
            return

        for i in range(now + 1, len(nums)):
            if i in vis:
                continue
            vis.add(i)
            current.append([now, i])
            self.dfs(now + 1, nums, vis, current, result, cache)
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
