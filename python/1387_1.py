import random
from typing import List


class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        dp = dict()
        dp[1] = 0
        for i in range(lo, hi + 1):
            n = 0
            now = i
            while dp.get(now) is None:
                if now % 2 == 0:
                    now /= 2
                else:
                    now = now * 3 + 1
                n += 1
            dp[i] = n + dp[now]

        arr = []
        for i in range(lo, hi + 1):
            arr.append((dp[i], i))
        return self.kth(arr, 0, len(arr) - 1, k - 1)[1]

    def kth(self, arr, l, r, k):
        le = l
        mid = l
        ri = r
        rnd = random.randint(l, r)
        arr[l], arr[rnd] = arr[rnd], arr[l]
        pivot = arr[l]
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
        pos = l + k
        if le <= pos <= ri:
            return arr[pos]
        elif pos < le:
            return self.kth(arr, l, le - 1, k)
        else:
            return self.kth(arr, ri + 1, r, k - (ri - l + 1))


class Solution1:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return self.kth(nums, 0, len(nums) - 1, len(nums) - k)

    def kth(self, arr, l, r, k):
        le = l
        mid = l
        ri = r
        rnd = random.randint(l, r)
        arr[l], arr[rnd] = arr[rnd], arr[l]
        pivot = arr[l]
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
        pos = l + k
        if le <= pos <= ri:
            return arr[pos]
        elif pos < le:
            return self.kth(arr, l, le - 1, k)
        else:
            return self.kth(arr, ri + 1, r, k - (ri - l + 1))


s = Solution()
print(s.getKth(12, 15, 2))
print(s.getKth(7, 11, 4))

# s = Solution1()
# print(s.findKthLargest([1, 3, 2, 4, 5, 6], 2))
