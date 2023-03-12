from typing import List


class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        def testBit(num, i):
            return ((num >> i) & 1) == 1

        if len(nums) == 0:
            return 0

        l = 0
        r = 0
        bitSetMap = dict()  # idx -> bitSet
        curBitSet = set()
        ans = 1
        while r < len(nums):
            num = nums[r]
            numBitSet = set()
            for i in range(32):
                if testBit(num, i):
                    numBitSet.add(i)
            for i in numBitSet:
                while i in curBitSet:
                    # pop until satisfied
                    leftBitSet = bitSetMap[l]
                    l += 1
                    for j in leftBitSet:
                        curBitSet.remove(j)
            for i in numBitSet:
                curBitSet.add(i)
            bitSetMap[r] = numBitSet
            ans = max(ans, r - l + 1)

            r += 1
        return ans


s = Solution()
print(s.longestNiceSubarray([1, 3, 8, 48, 10]))
print(s.longestNiceSubarray([3, 1, 5, 11, 13]))
