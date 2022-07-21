from typing import List


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        diff = dict()
        zero_arr = []
        one_arr = []

        ans = 0
        zero = 0
        one = 0
        for i, num in enumerate(nums):
            if num == 0:
                zero += 1
            else:
                one += 1

            if zero == one:
                ans = max(ans, zero * 2)
            elif diff.get(zero - one) is not None:
                idx = diff[zero - one]
                ans = max(ans, (one - one_arr[idx]) * 2)

            zero_arr.append(zero)
            one_arr.append(one)
            if diff.get(zero - one) is None:
                diff[zero - one] = i

        return ans


s = Solution()
print(s.findMaxLength([0, 0, 1, 0, 1]))
print(s.findMaxLength([0, 1]))
print(s.findMaxLength([0, 1, 0]))
print(s.findMaxLength([1, 0, 0, 0, 0, 1]))
print(s.findMaxLength([0, 0, 0, 1, 0, 1, 1, 0]))
