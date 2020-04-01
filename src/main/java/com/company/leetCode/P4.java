package com.company.leetCode;

public class P4 {
    private int findKthFromSortedArrays(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        if (l1 > r1) return nums2[l2 + k];
        if (l2 > r2) return nums1[l1 + k];
        int mid1 = (l1 + r1) >> 1;  // 取的是下位中位数，因此当k + 1与num相等时应该甩左 边
        int mid2 = (l2 + r2) >> 1;
        int num = mid1 - l1 + 1 + mid2 - l2 + 1;
        if (num > k + 1) {
            if (nums1[mid1] <= nums2[mid2]) return findKthFromSortedArrays(nums1, l1, r1, nums2, l2, mid2 - 1, k);
            else return findKthFromSortedArrays(nums1, l1, mid1 - 1, nums2, l2, r2, k);
        } else { // num选少了时，甩mid小的那个数组的左边，如果k正好且mid相等那么直接返回任意一个mid，如果k正好midA大那么结果在Amid的左边
            // （包含Amid），因此可以甩数组B，也就是说小的那个被甩肯定没问题
            if (nums1[mid1] <= nums2[mid2])
                return findKthFromSortedArrays(nums1, mid1 + 1, r1, nums2, l2, r2, k - (mid1 - l1 + 1));
            else return findKthFromSortedArrays(nums1, l1, r1, nums2, mid2 + 1, r2, k - (mid2 - l2 + 1));
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthSum = nums1.length + nums2.length;
        if (lengthSum % 2 == 1)
            return findKthFromSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, lengthSum / 2);
        else
            return ((double) findKthFromSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, lengthSum / 2)
                    + findKthFromSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, lengthSum / 2 - 1)) / 2;
    }

    public static void main(String[] args) {
        P4 p4 = new P4();
        System.out.println(p4.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
