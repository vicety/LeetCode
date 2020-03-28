package com.company.leetCode;

import java.util.Arrays;

public class P321_2 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[nums1.length + nums2.length];
        for (int i = 0; i <= Math.min(nums1.length, k); i++) {
            int len2 = k - i;
            if (len2 > nums2.length) continue;
//            int[] arr1 = solveOneArr(nums1, 0, i);
            int[] arr1 = maxNumberOfSingleArray(nums1, i);
//            int[] arr2 = solveOneArr(nums2, 0, len2);
            int[] arr2 = maxNumberOfSingleArray(nums2, len2);
            int[] merged = mergeArr(arr1, arr2);
            if (isBiggerThan(merged, 0, ans, 0)) ans = merged;
        }
        return ans;
    }

    //get the largest k numbers when keeping the relative order
    private int[] maxNumberOfSingleArray(int[] nums, int k) {
        int[] result = new int[k];
        if (k == 0) return result;

        int len = nums.length;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            while ((len - i - 1) + (idx + 1) > k && idx > 0 && nums[i] > result[idx - 1]) idx--;
            if (idx < k) result[idx++] = nums[i];
        }
        return result;
    }

    private int[] solveOneArr(int[] arr, int st, int n) {
        if (n == 0) return new int[]{};
        int[] ans = new int[n];
        int limitExclusive = arr.length - n + 1;
        int max = -1;
        int maxIndex = -1;
        for (int i = st; i < limitExclusive; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        ans[0] = max;
        System.arraycopy(solveOneArr(arr, maxIndex + 1, n - 1), 0, ans, 1, n - 1);
        return ans;
    }

    private int[] mergeArr(int[] a, int[] b) {
        int pa = 0;
        int pb = 0;
        int p0 = 0;
        int[] ans = new int[a.length + b.length];
        while (pa < a.length && pb < b.length) {
            ans[p0++] = isBiggerThan(a, pa, b, pb) ? a[pa++] : b[pb++];
        }
        while (pa < a.length) ans[p0++] = a[pa++];
        while (pb < b.length) ans[p0++] = b[pb++];
        return ans;
    }

    private boolean isBiggerThan(int[] a, int stA, int[] b, int stB) {
        while (stA < a.length && stB < b.length) {
            if (a[stA] > b[stB]) return true;
            else if (a[stA] < b[stB]) return false;
            stA++;
            stB++;
        }
        if (stA == a.length) return false;
        if (stB == b.length) return true;
        return false;
    }

    public static void main(String[] args) {
        P321_2 p321_2 = new P321_2();
//        System.out.println(Arrays.toString(p321_2.maxNumber(new int[]{8, 6, 9}, new int[]{1, 7, 5}, 3)));
//        System.out.println(Arrays.toString(p321_2.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
//        System.out.println(Arrays.toString(p321_2.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)));
//        System.out.println(Arrays.toString(p321_2.maxNumber(new int[]{9, 1, 2, 5, 8, 3}, new int[]{3, 4, 6, 5}, 5)));
        System.out.println(Arrays.toString(p321_2.maxNumber(new int[]{2, 5, 6, 4, 4, 0}, new int[]{7, 3, 8, 0, 6, 5, 7, 6, 2}, 15)));
    }
}
