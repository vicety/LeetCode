package com.company.leetCode;

public class P88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, nums1.length - m, m);
        for (int i = 0; i < nums1.length; i++) System.out.print(nums1[i] + " ");
        int p1 = nums1.length - m;
        int p2 = 0;
        int p = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] <= nums2[p2]) {
                nums1[p++] = nums1[p1++];
            } else nums1[p++] = nums2[p2++];
        }
        while (p1 < nums1.length) nums1[p++] = nums1[p1++];
        while (p2 < nums2.length) nums1[p++] = nums2[p2++];
    }

    public static void main(String[] args) {
        P88 p88 = new P88();
        System.out.println(Integer.parseInt(""));
    }
}
