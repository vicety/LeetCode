from typing import List


class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) < 2:
            return

        # 3 -> 1, 4 -> 1, 5 -> 2
        # odd -> (n+1)/2
        # print("find {}-th".format((len(nums) - 1) // 2))
        midNum = self.findKth(nums, 0, len(nums) - 1, (len(nums) - 1) // 2)
        # print(midNum)
        oddPtr = len(nums) - 1
        if oddPtr % 2 == 1:
            oddPtr -= 1
        evenPtr = 1

        result = [0] * len(nums)

        for num in nums:
            if num < midNum:
                result[oddPtr] = num
                oddPtr -= 2
            elif num > midNum:
                result[evenPtr] = num
                evenPtr += 2

        while oddPtr >= 0:
            result[oddPtr] = midNum
            oddPtr -= 2
        while evenPtr < len(nums):
            result[evenPtr] = midNum
            evenPtr += 2

        for i in range(len(nums)):
            nums[i] = result[i]

    def findKth(self, nums, l, r, k):  # start from 0
        pivot = nums[l]
        le = l
        mid = l + 1
        ri = r
        while mid <= ri:
            if nums[mid] == pivot:
                mid += 1
            elif nums[mid] < pivot:
                nums[mid], nums[le] = nums[le], nums[mid]
                mid += 1
                le += 1
            else:
                nums[ri], nums[mid] = nums[mid], nums[ri]
                ri -= 1

        if l + k >= le and l + k < mid:
            return nums[l + k]
        elif l + k < le:
            return self.findKth(nums, l, le - 1, k)
        else:
            return self.findKth(nums, ri + 1, r, k - (ri - l + 1))


# arr = [2, 5, 3, 7, 2, 7, 2, 8, 2, 1, 9]
# result = []
# for i in range(len(arr)):
#     result.append(findKth(arr, 0, len(arr) - 1, i))
# print(result)

s = Solution()
# nums = [1, 5, 1, 1, 6, 4]
# nums = [4, 5, 5, 6]
nums = [1, 3, 2, 2, 3, 1]
s.wiggleSort(nums)
print(nums)
