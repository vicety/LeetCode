from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        return self.search_inner(nums, 0, len(nums) - 1, target)

    def search_inner(self, nums, l, r, target):
        if l > r:
            return -1

        mid = (l + r) // 2
        if nums[mid] >= nums[l]:
            if nums[l] <= target <= nums[mid]:
                return self.binary_search(nums, l, mid, target)
            else:
                return self.search_inner(nums, mid + 1, r, target)
        else:
            if nums[mid] <= target <= nums[r]:
                return self.binary_search(nums, mid, r, target)
            else:
                return self.search_inner(nums, l, mid - 1, target)

    def binary_search(self, nums, l, r, target):
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return -1


