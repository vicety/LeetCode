from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        nums = []
        weight = dict()
        for candidate in candidates:
            if candidate > target:
                continue
            if not candidate in weight:
                weight[candidate] = 1
                nums.append(candidate)
            else:
                weight[candidate] += 1

        self.dfs(nums, weight, 0, [], 0, ans, target)
        return ans

    def dfs(self, nums, weight, i, cur, curSum, ans, target):
        if curSum > target:
            return
        if i == len(nums):
            if curSum == target:
                ans.append(cur.copy())
            return
        for j in range(weight[nums[i]] + 1):
            for _ in range(j):
                cur.append(nums[i])
            self.dfs(nums, weight, i + 1, cur, curSum + nums[i] * j, ans, target)
            for _ in range(j):
                cur.pop()


s = Solution()
print(s.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
print(s.combinationSum2([2, 5, 2, 1, 2], 5))
