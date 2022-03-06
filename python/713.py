from typing import List


class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:  # ensure k >= 2 # 考虑 [1, 1, 1] k = 1
            return 0

        st = 0
        ans = 0
        window_product = 1
        for ed in range(len(nums)):  # subarray less than K that ends at st
            window_product *= nums[ed]

            while window_product >= k:
                window_product /= nums[st]
                st += 1

            ans += (ed - st + 1)

        return ans


s = Solution()
print(s.numSubarrayProductLessThanK([10, 5, 2, 6], 100))
print(s.numSubarrayProductLessThanK([1, 2, 3, 4, 5, 6], 31))
