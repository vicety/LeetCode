from typing import (
    List,
)


class Solution:
    """
    @param nums:  an array of n integers
    @param target: a target
    @return: the number of index triplets satisfy the condition nums[i] + nums[j] + nums[k] < target
    """

    def three_sum_smaller(self, nums: List[int], target: int) -> int:
        # Write your code here
        nums.sort()
        ans = 0
        for i in range(len(nums)):
            num_i = nums[i]
            target_now = target - num_i
            j = i + 1
            k = len(nums) - 1
            while j < k:
                if nums[k] + nums[j] < target_now:
                    ans += k - j
                    j += 1
                else:
                    k -= 1
        return ans


s = Solution()
print(s.three_sum_smaller([-2, 0, -1, 3], 2))
