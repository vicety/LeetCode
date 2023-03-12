from typing import List


class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        def rev(num):
            if num == 0:
                return 0
            num_s = str(num)
            num_rev_s = num_s[::-1]
            while num_rev_s[0] == '0':
                num_rev_s = num_rev_s[1:]
            return int(num_rev_s)

        revs = list(map(lambda x: rev(x), nums))
        # print(revs)
        diff = list(map(lambda i: nums[i] - revs[i], list(range(len(nums)))))
        # print(diff)
        di = dict()
        for n in diff:
            di[n] = di.get(n, 0) + 1
        ans = 0
        mod = int(1e9 + 7)
        for n, val in di.items():
            ans = (ans + val * (val - 1) // 2) % mod
        return ans


#  num[i]+rev[j]=rev[i]+num[j]
#  num[i]-num[j]=rev[i]-rev[j]
#  num[i]-rev[i]=num[j]-rev[j]


s = Solution()
print(s.countNicePairs([13, 10, 35, 24, 76]))
print(s.countNicePairs([42, 11, 1, 97]))
