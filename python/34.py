from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        hasElement = [False]
        l = self.searchLeft(nums, 0, len(nums) - 1, target, hasElement)
        if not hasElement[0]:
            return [-1, -1]
        r = self.searchRight(nums, 0, len(nums) - 1, target)
        return [l, r]

    def searchLeft(self, nums, l, r, target, hasElement):
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                r = mid - 1
                hasElement[0] = True
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return l

    def searchRight(self, nums, l, r, target):
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return r
