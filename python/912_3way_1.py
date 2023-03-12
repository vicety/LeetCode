import random
from typing import List

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.sort(nums, 0, len(nums) - 1)
        return nums

    # 所有的位置 left, mid, right 都是开边界
    def sort(self, arr, l, r):
        if l >= r:
            return
        rnd = random.randint(l, r)
        arr[l], arr[rnd] = arr[rnd], arr[l]
        pivot = arr[l]
        left = l
        mid = l + 1
        right = r
        while mid <= right:
            if arr[mid] < pivot:
                arr[left], arr[mid] = arr[mid], arr[left]
                left += 1
                mid += 1
            elif arr[mid] == pivot:
                mid += 1
            else:
                arr[mid], arr[right] = arr[right], arr[mid]
                right -= 1
        self.sort(arr, l, left - 1)
        self.sort(arr, mid, r)

s = Solution()
print(s.sortArray([1, 5, 8, 2, 7, 2, 2, 7, 2, 9]))