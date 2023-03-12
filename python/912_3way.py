import random
from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.sort(nums, 0, len(nums) - 1)
        return nums

    def sort(self, arr, l, r):
        if l >= r:
            return

        rnd = random.randint(l, r)
        arr[l], arr[rnd] = arr[rnd], arr[l]
        pivot = arr[l]
        le = l
        mid = l + 1
        ri = r
        while mid <= ri:
            if arr[mid] == pivot:
                mid += 1
            elif arr[mid] < pivot:
                arr[le], arr[mid] = arr[mid], arr[le]
                le += 1
                mid += 1
            else:
                arr[mid], arr[ri] = arr[ri], arr[mid]
                ri -= 1

        self.sort(arr, l, le - 1)
        self.sort(arr, ri + 1, r)


s = Solution()
print(s.sortArray([1, 5, 8, 2, 7, 2, 2, 7, 2, 9]))

# 虚拟化 自动化测试
# EDA 比较慢 emulation