import random
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return self.solve(nums, 0, len(nums) - 1, k - 1)

    def solve(self, arr, l, r, k):  # k index from 0
        # if l == r:
        #     return arr[l]
        # rnd = random.randint(l, r)
        # arr[l], arr[rnd] = arr[rnd], arr[l]
        pivot = arr[l]
        le, mid, ri = l, l + 1, r
        while mid <= ri:
            if arr[mid] == pivot:
                mid += 1
            elif arr[mid] > pivot:
                arr[le], arr[mid] = arr[mid], arr[le]
                le += 1
                mid += 1
            else:
                arr[mid], arr[ri] = arr[ri], arr[mid]
                ri -= 1

        if le - l <= k <= ri - l:
            return arr[l + k]
        elif k < le - l:
            return self.solve(arr, l, le - 1, k)
        else:
            return self.solve(arr, ri + 1, r, k - (ri - l + 1))


s = Solution()

arr = [3, 2, 1, 5, 6, 4]
for i in range(10):
    print(s.findKthLargest(arr, 3))
# for i in range(len(arr)):
#     print(s.findKthLargest(arr, i + 1))
