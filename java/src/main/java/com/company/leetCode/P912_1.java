package com.company.leetCode;

import java.util.Random;

public class P912_1 {

}

class Solution912_1 {
    public int[] sortArray(int[] nums) {
        // qsort
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    private void qsort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        Random random = new Random();
        int rnd = random.nextInt(r - l + 1);  // exclusive
        swap(nums, l, l + rnd);
        int pivot = nums[l];

        // le (exclusive) mi (exclusive) ri (exclusive)
        int le = l;
        int mi = l + 1;
        int ri = r;

        while (mi <= ri) {
            if (nums[mi] < pivot) {
                swap(nums, mi, le);
                mi++;
                le++;
            } else if (nums[mi] == pivot) {
                mi++;
            } else {
                swap(nums, mi, ri);
                ri--;
            }
        }

        qsort(nums, l, le - 1);
        qsort(nums, ri + 1, r);
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private void msortInplace(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        msortInplace(nums, l, mid);
        msortInplace(nums, mid + 1, r);

        // allocate

        // while
        // while
        // while
    }
}