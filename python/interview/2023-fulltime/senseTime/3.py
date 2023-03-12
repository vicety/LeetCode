class Solution:
    def pick(self, nums):
        if len(nums) == 1:
            return 0
        # non pick last, picked last
        # solve(i) = solve(i-1) or solve(i-2) + nums[i]
        dp = [0, 0]
        for num in nums[1:]:
            newDp = [0, 0]
            # not take, take
            newDp[1] = dp[0] + num
            newDp[0] = max(dp[0], dp[1])
            dp = newDp
        ans1 = max(dp)
        dp = [0, 0]
        for num in nums[:-1]:
            newDp = [0, 0]
            # not take, take
            newDp[1] = dp[0] + num
            newDp[0] = max(dp[0], dp[1])
            dp = newDp
        ans2 = max(dp)
        return max(ans1, ans2)


s = Solution()
# print(s.pick([3, 6, 2, 3, 10]))
# print(s.pick([]))
# print(s.pick([3, 4]))
# print(s.pick([1]))
print(s.pick([1, 2, 4, 8, 16]))
