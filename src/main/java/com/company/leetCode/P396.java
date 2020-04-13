package com.company.leetCode;

public class P396 {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int ans = 0;
        for (int i : A) sum += i;
        int[] withOutThis = new int[A.length];
        for (int i = 0; i < A.length; i++) withOutThis[i] = sum - A[i];
        int value = 0;
        for (int i = 0; i < A.length; i++) value += i * A[i];
        ans = value;
        for (int i = A.length - 1; i >= 1; i--) {
            value = value - (A.length - 1) * A[i] + withOutThis[i];
            ans = Math.max(ans, value);
        }
        return ans;
    }

    public static void main(String[] args) {
        P396 p396 = new P396();
        System.out.println(p396.maxRotateFunction(new int[]{4, 9}));
    }
}
