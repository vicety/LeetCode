package com.company.leetCode;

import java.util.Arrays;

/**
 * failed case：[3,9] [8,9] 3
 */
public class P321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int p0 = 0;
        int p1 = 0, p2 = 0; // p1 p2 inclusive
        while (k > 0) {
            int freedom = nums1.length + nums2.length - p1 - p2 - k + 1;
            int limit1 = Math.min(nums1.length, p1 + freedom); // exclusive
            int limit2 = Math.min(nums2.length, p2 + freedom);
            int max1 = -1;
            int max1Index = -1;
            int max2 = -1;
            int max2Index = -1;
            for (int i = limit1 - 1; i >= p1; i--) {
                if (nums1[i] > max1) {
                    max1 = nums1[i];
                    max1Index = i;
                }
            }
            for (int i = limit2 - 1; i >= p2; i--) {
                if (nums2[i] > max2) {
                    max2 = nums2[i];
                    max2Index = i;
                }
            }
            if (max1 > max2) {
                ans[p0++] = max1;
                p1 = max1Index + 1;
            } else if (max2 > max1) {
                ans[p0++] = max2;
                p2 = max2Index + 1;
            } else {
                ans[p0++] = max1;
                if (limit1 == nums1.length) p2 = max2Index + 1;
                else if (limit2 == nums2.length) p1 = max1Index + 1;
                else {
                    int nextMax1 = -1;
                    int nextMax2 = -1;
                    int nextLimit1 = Math.min(nums1.length, limit1 + (max1Index - p1 + 1));
                    int nextLimit2 = Math.min(nums2.length, limit2 + (max2Index - p2 + 1));
                    for (int i = limit1; i < nextLimit1; i++) nextMax1 = Math.max(nextMax1, nums1[i]);
                    for (int i = limit2; i < nextLimit2; i++) nextMax2 = Math.max(nextMax2, nums2[i]);
                    if (nextMax1 > nextMax2) p1 = max1Index + 1;
                    else p2 = max2Index + 1;
                }
            }
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        P321 p321 = new P321();
//        System.out.println(Arrays.toString(p321.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
        System.out.println(Arrays.toString(p321.maxNumber(new int[]{8, 6, 9}, new int[]{1, 7, 5}, 3)));
    }
}
