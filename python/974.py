from typing import List


# -4 % 5 = 1
# 4 % 5 = 4
# 1 % 5 = 1

# 即使是负数，模也是对的
class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        di = {0: 1}
        cur_sum = 0
        ans = 0
        for num in nums:
            cur_sum += num
            cur_mod = cur_sum % k
            if di.get(cur_mod):
                ans += di[cur_mod]
            di[cur_mod] = di.get(cur_mod, 0) + 1

        return ans


s = Solution()
print(s.subarraysDivByK([-4, 4, 1], 5))
print(s.subarraysDivByK([4, 5, 0, -2, -3, 1], 5))
print(s.subarraysDivByK([2, -2, 2, -4], 6))
