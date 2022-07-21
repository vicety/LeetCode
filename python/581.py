from typing import List


class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        minL = -1
        minR = -1
        i = 0
        last = float('-inf')
        while i < len(nums) and nums[i] >= last:
            last = nums[i]
            i += 1
        if i == len(nums):
            return 0
        minL = i - 1

        i = len(nums) - 1
        last = float('inf')
        while i >= 0 and nums[i] <= last:
            last = nums[i]
            i -= 1
        minR = i + 1
        minVal = float('inf')
        maxVal = float('-inf')
        for i in range(minL, minR + 1):
            minVal = min(minVal, nums[i])
            maxVal = max(maxVal, nums[i])

        # find first larger than minVal
        l = 0
        r = minL - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] <= minVal:
                l = mid + 1
            else:
                r = mid - 1
        le = l
        maxVal = max(maxVal, nums[le])

        # find first less than maxVal
        l = minR + 1
        r = len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] >= maxVal:
                r = mid - 1
            else:
                l = mid + 1
        ri = r

        return ri - le + 1

        # l = minL - 1
        # r = minR + 1
        # while (l >= 0 and nums[l] > minVal) or (r < len(nums) and nums[r] < maxVal):
        #     while l >= 0 and nums[l] > minVal:
        #         maxVal = max(maxVal, nums[l])
        #         l -= 1
        #     while r < len(nums) and nums[r] < maxVal:
        #         minVal = min(minVal, nums[r])
        #         r += 1

        # return r - l - 1


s = Solution()
print(s.findUnsortedSubarray([1, 3, 2, 2, 2]))
print(s.findUnsortedSubarray([2, 6, 4, 8, 10, 9, 15]))
print(s.findUnsortedSubarray([1, 3, 5, 4, 8, 2, 7, 11]))
print(s.findUnsortedSubarray([1, 2, 3, 4]))
print(s.findUnsortedSubarray([1]))
print(s.findUnsortedSubarray([1, 2, 3, 3, 3]))


class QueryRequest:
    def __init__(self, query: str, titles: List[str]):
        self.query = query
        self.titles = titles


class QueryResponse:
    def __init__(self):
        # the recommendation that returns from the backend, for example, titles, summaries ...
        pass


def theFunctionThatYouProvideMe(request: QueryRequest) -> QueryResponse:
    # your logic to do the recommendation based on information in QueryRequest
    pass
