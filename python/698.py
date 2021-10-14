from typing import List


class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        avg = sum(nums) // k
        if sum(nums) % k != 0:
            return False
        for num in nums:
            if num > avg:
                return False

        def search(lst, start, cur, n):
            if cur > avg:
                return False
            if cur == avg:
                return search(lst, 0, 0, n + 1)
            if n == k:
                return True
            for i in range(start, len(lst)):
                num = lst[i]
                if used[i]:
                    continue
                used[i] = True
                if search(lst, i + 1, cur + num, n):
                    return True
                used[i] = False
            return False

        used = [False] * len(nums)
        return search(nums, 0, 0, 0)


S = Solution()
print(S.canPartitionKSubsets([4, 3, 2, 3, 5, 2, 1], 4))
print(S.canPartitionKSubsets([1, 2, 3, 4], 3))
