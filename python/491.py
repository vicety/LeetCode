from typing import List


class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        ans = set()
        self.dfs(nums, 0, [], ans)
        return list(map(lambda x: list(map(lambda y: int(y), x.split('|'))), ans))

    def dfs(self, nums, nowi, now: List[int], ans):
        if nowi == len(nums):
            if len(now) > 1:
                ans.add("|".join(map(lambda x: str(x), now)))
            return
        self.dfs(nums, nowi + 1, now, ans)
        if not now or now[-1] <= nums[nowi]:
            self.dfs(nums, nowi + 1, now + [nums[nowi]], ans)


s = Solution()
print(s.findSubsequences([4, 6, 7, 7]))
# print(s.findSubsequences([4, 4, 3, 2, 1]))
