from typing import List


class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        def testBit(num, i):
            return ((num >> i) & 1) == 1

        if len(nums) == 0:
            return 0

        l = 0
        r = 0
        cur = 0
        ans = 1
        while r < len(nums):
            num = nums[r]
            while cur & num != 0:
                cur &= ~nums[l]
                l += 1
            cur |= num
            ans = max(ans, r - l + 1)
            r += 1
        return ans


s = Solution()
print(s.longestNiceSubarray([1, 3, 8, 48, 10]))
print(s.longestNiceSubarray([3, 1, 5, 11, 13]))

# print(~1)

# 交易系统 c++ python 投研平台 下层的数据服务 数据处理 API层的服务
# 技术栈 python 后端 fastAPI flask 包 k8s 正常用 MySQL TSDB
# 上下班 8.3 - 6/7 事情做完
# 上海
