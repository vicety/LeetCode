from collections import deque
from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return
        zero_r, one_r, two_l = 0, 0, len(nums) - 1
        while one_r <= two_l:
            if nums[one_r] == 0:
                nums[zero_r], nums[one_r] = nums[one_r], nums[zero_r]
                zero_r += 1
                one_r += 1
            elif nums[one_r] == 1:
                one_r += 1
            elif nums[one_r] == 2:
                nums[one_r], nums[two_l] = nums[two_l], nums[one_r]
                two_l -= 1
