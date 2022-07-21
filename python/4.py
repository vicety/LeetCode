from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        len1 = len(nums1)
        len2 = len(nums2)
        k = (len1 + len2) // 2

        if (len1 + len2) % 2:
            # len 3 -> index 1  len 5 -> index 2
            return self.helper(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k)
        else:
            # len 2 -> index 0 1
            # len 4 -> index 1 2
            return (self.helper(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k)
                    + self.helper(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k - 1)) / 2

    def helper(self, nums1, l1, r1, nums2, l2, r2, k):
        # print(nums1, l1, r1, nums2, l2, r2, k)
        if l1 > r1:
            # print("pick {}".format(nums2[l2 + k]))
            return nums2[l2 + k]
        elif l2 > r2:
            # print("pick {}".format(nums1[l1 + k]))
            return nums1[l1 + k]
        else:
            mid1 = (l1 + r1) // 2
            mid2 = (l2 + r2) // 2
            if nums1[mid1] <= nums2[mid2]:
                minList, minL, minR, minMid = nums1, l1, r1, mid1
                maxList, maxL, maxR, maxMid = nums2, l2, r2, mid2
            else:
                minList, minL, minR, minMid = nums2, l2, r2, mid2
                maxList, maxL, maxR, maxMid = nums1, l1, r1, mid1
            # we can ensure lower half of minList or higher half of maxList
            # is always less or more than the other half in another list
            lessLen = (minMid - minL + 1)
            moreLen = (maxMid - maxL + 1)
            # print("k+1 {} lessLen {}".format(k + 1, lessLen))
            if k + 1 >= lessLen + moreLen:
                return self.helper(minList, minMid + 1, minR, maxList, maxL, maxR, k - lessLen)
            # it's always true len lessHalf1 < len less + len moreHalf1
            else:
                return self.helper(minList, minL, minR, maxList, maxL, maxMid - 1, k)


s = Solution()
print(s.findMedianSortedArrays([1, 2], [3, 4]))
print(s.findMedianSortedArrays([1, 3], [2]))
print(s.findMedianSortedArrays([1, 3], [2, 4]))
print(s.findMedianSortedArrays([1, 2, 3], [4, 5, 6]))
print(s.findMedianSortedArrays([0, ], [-1, 0, 1]))

# TODO 大顶堆
