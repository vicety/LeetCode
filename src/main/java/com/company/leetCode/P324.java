package com.company.leetCode;

import java.util.Arrays;
import java.util.Random;

public class P324 {
    public void wiggleSort(int[] nums) {
        int mid = findK(nums, (nums.length - 1) / 2);
        int ltCnt = 0;
        for (int num : nums) if (num < mid) ltCnt++;
        int validLeqCnt = (nums.length + 1) / 2;
        int validLeqMid = validLeqCnt - ltCnt;
        boolean nowGt = false;
        int tmp;
        int[] lt = new int[(nums.length + 1) / 2];
        int[] gt = new int[nums.length / 2];
        int plt = 0, pgt = 0;
        while (validLeqMid-- != 0) lt[plt++] = mid;
        Arrays.fill(gt, mid);
        for (int num : nums) {
            if (num < mid) lt[plt++] = num;
            else if (num > mid) gt[pgt++] = num;
        }
        plt = 0;
        pgt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nowGt) nums[i] = gt[pgt++];
            else nums[i] = lt[plt++];
            nowGt = !nowGt;
        }
    }

    // k start from 0
    private int findK(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = partition(arr, l, r);
            if (mid - l == k) return arr[mid];
            else if (k > mid - l) {
                k -= (mid - l + 1);
                l = mid + 1;
            } else r = mid - 1;
        }
        return -1;
    }

    private int partition(int[] arr, int l, int r) {
        Random random = new Random();
        int swap = l + random.nextInt(r - l + 1);
        int tmp;
        tmp = arr[r];
        arr[r] = arr[swap];
        arr[swap] = tmp;
        int mid = l;
        for (int i = l; i < r; i++) {
            if (arr[i] <= arr[r]) {
                tmp = arr[mid];
                arr[mid] = arr[i];
                arr[i] = tmp;
                mid++;
            }
        }
        tmp = arr[mid];
        arr[mid] = arr[r];
        arr[r] = tmp;
        return mid;
    }

    public static void main(String[] args) {
        P324 p324 = new P324();
        int[] arr = new int[]{1, 3, 2, 2, 3, 1};
//        int[] arr = new int[]{0,1,1,2,2,2,2,2,3,3,4};
//        int[] arr = new int[]{5, 3, 1, 2, 6, 7, 8, 5, 5};
        p324.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
