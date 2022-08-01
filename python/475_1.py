from typing import List


class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        ans = 0
        houses.sort()
        heaters.sort()

        for house in houses:
            lower = self.find(heaters, house, True)
            higher = self.find(heaters, house, False)
            if lower == -1:
                l = float('-inf')
            else:
                l = heaters[lower]
            if higher == len(heaters):
                r = float('inf')
            else:
                r = heaters[higher]
            ans = max(ans, min(house - l, r - house))

        return ans

    def find(self, nums, target, lower):
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        if lower:
            return r
        else:
            return l

s = Solution()
print(s.findRadius([1, 2, 3, 4], [1, 4]))
print(s.findRadius([1, 5], [0, 2]))