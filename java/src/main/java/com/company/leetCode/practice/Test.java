package com.company.leetCode.practice;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] t = new int[10];
        int now = 0;
        t[now++] = f(t, now) + 1;
        System.out.println(Arrays.toString(t));
        t[now++] = f(t, now) + 1;
        System.out.println(Arrays.toString(t));
        t[now++] = f(t, now) + 1;
        System.out.println(Arrays.toString(t));
    }

    private static int f(int[] arr, int now) {
        System.out.println(now);
        return arr[now];
    }
}
