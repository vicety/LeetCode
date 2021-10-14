package com.company.algorithms;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Qsort {

    public void qsort(int[] arr, int l, int r) {
        while (l < r) {
            int mid = partition(arr, l, r);
            qsort(arr, l, mid - 1);
            qsort(arr, mid + 1, r);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int base = arr[r];
        int cur = l;
        for (int i = l; i < r; i++) {
            if (arr[i] < base) {
                int tmp = arr[i];
                arr[i] = arr[cur];
                arr[cur++] = tmp;
            }
        }
        int tmp = arr[cur];
        arr[cur] = arr[r];
        arr[r] = tmp;
        return cur;
    }

    public static void main(String[] args) {
        Qsort qsort = new Qsort();
        Integer[] iarr = new Integer[]{};
        List<Integer> list = new ArrayList<>(Arrays.asList(iarr));
    }
}
