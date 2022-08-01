from typing import List


class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        bits = dict()
        ans = 0

        for i in range(0, 32):
            bits[i] = 0
        for j, num in enumerate(nums):
            i = 0
            while True:
                if num % 2 == 1:
                    ans += j - bits[i]
                    bits[i] += 1
                else:
                    ans += bits[i]
                i += 1
                num //= 2
                if num == 0:
                    for k in range(i, 32):
                        ans += bits[k]
                    break

        return ans


s = Solution()
print(s.totalHammingDistance([31, 15, 7, 6]))
