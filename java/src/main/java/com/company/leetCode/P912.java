package com.company.leetCode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P912 {
    private void sort(int[] arr, int l, int r) {
        if (l <= r) {
            int mid = partition(arr, l, r);
            sort(arr, l, mid - 1);
            sort(arr, mid + 1, r);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int base = arr[r];
        int mid = l;
        for (int i = l; i < r; i++) {
            if (arr[i] <= base) {
                int tmp = arr[mid];
                arr[mid] = arr[i];
                arr[i] = tmp;
                mid++;
            }
        }
        int tmp = arr[r];
        arr[r] = arr[mid];
        arr[mid] = tmp;
        return mid;
    }

    public List<Integer> sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return IntStream.of(nums).boxed().collect(Collectors.toList());
    }
}
