from typing import List


class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        mod_dict = {0: [-1]}
        now_sum = 0

        for i, num in enumerate(nums):
            now_sum += num
            mod = now_sum % k

            for j in mod_dict.get(mod, []):
                if i - j >= 2:
                    return True

            if mod_dict.get(mod) is None:
                mod_dict[mod] = []
            mod_dict[mod].append(i)

        return False


s = Solution()
print(s.checkSubarraySum([1, 2, 3, 4], 6))
print(s.checkSubarraySum([23, 2, 4, 6, 7], 6))
print(s.checkSubarraySum([6], 6))
print(s.checkSubarraySum([6, 0], 6))
print(s.checkSubarraySum([0, 0], 6))
