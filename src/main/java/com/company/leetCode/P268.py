class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        ans = reduce(lambda x, y : x ^ y,  range(n))
        nums.append(ans)
        return reduce(lambda x, y : x ^ y, nums)