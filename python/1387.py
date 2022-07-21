from queue import PriorityQueue
from collections import deque
import random


class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        dp = [-1] * 500000  # dp可以动态，用dict
        dp[1] = 0
        data = []
        for i in range(lo, hi + 1):
            now = i
            acc = 0
            while dp[now] == -1:
                if now % 2 == 0:
                    now //= 2
                else:
                    now = now * 3 + 1
                acc += 1
            dp[i] = acc + dp[now]
            data.append((dp[i], i))

        return self.kth(data, 0, len(data) - 1, k - 1)[1]

    def kth(self, arr, l, r, k) -> int:
        if l == r:
            return arr[l]
        rnd = random.randint(l, r)
        arr[l], arr[rnd] = arr[rnd], arr[l]
        pivot = arr[l]
        le, mid, ri = l, l + 1, r
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

        if le - l <= k <= ri - l:
            return arr[l + k]
        elif k < le - l:
            return self.kth(arr, l, le - 1, k)
        else:
            return self.kth(arr, ri + 1, r, k - (ri - l + 1))


s = Solution()
print(s.getKth(1, 1000, 777))

# i = 447
# while i != 1:
#     print(i)
#     if i % 2 == 0:
#         i //= 2
#     else:
#         i = i * 3 + 1
