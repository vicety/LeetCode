import random
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        k -= 1
        return self.solve(nums, 0, len(nums) - 1, k)

    def solve(self, arr, l, r, k):
        rnd = random.randint(l, r)
        arr[l], arr[rnd] = arr[rnd], arr[l]
        pivot = arr[l]
        left, right = l, r
        mid = l
        while mid <= r:
            if arr[mid] == pivot:
                mid += 1
            elif arr[mid] > pivot:
                arr[l], arr[mid] = arr[mid], arr[l]
                l += 1
                mid += 1
            else:
                arr[mid], arr[r] = arr[r], arr[mid]
                r -= 1
        if l <= k + left < mid:
            return arr[left + k]
        elif k + left < l:
            return self.solve(arr, left, l - 1, k)
        else:
            return self.solve(arr, mid, right, k - (mid - left))

s = Solution()

arr = [3, 2, 1, 5, 6, 4]
# for i in range(10):
#     print(s.findKthLargest(arr, 3))
for i in range(len(arr)):
    print(s.findKthLargest(arr, i + 1))