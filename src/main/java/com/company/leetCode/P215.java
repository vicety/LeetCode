package com.company.leetCode;

import java.util.Random;

public class P215 {

    private int solve(int[] nums, int l, int r, int k) {
        int mid = partition(nums, l, r);
        if (mid - l == k) return nums[mid];
        else if (mid - l < k) return solve(nums, mid + 1, r, k - (mid - l + 1));
        else return solve(nums, l, mid - 1, k);
    }

    private int partition(int[] arr, int l, int r) {
        Random random = new Random();
        int pivot = l + random.nextInt(r - l + 1);
        int t = arr[r];
        arr[r] = arr[pivot];
        arr[pivot] = t;
        int mid = l;
        int base = arr[r];
        for (int i = l; i < r; i++) {
            if (arr[i] >= base) {
                int tmp = arr[i];
                arr[i] = arr[mid];
                arr[mid++] = tmp;
            }
        }
        arr[r] = arr[mid];
        arr[mid] = base;
        return mid;
    }

    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        return solve(nums, l, r, k - 1);
    }

    public static void main(String[] args) {
        P215 p215 = new P215();
        System.out.println(p215.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
