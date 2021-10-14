package com.company.leetCode;

public class P135_3 {
    public int candy(int[] ratings) {
        int[] ans = new int[ratings.length];
        ans[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) ans[i] = ans[i - 1] + 1;
            else ans[i] = 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) ans[i] = Math.max(ans[i], ans[i + 1] + 1);
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) sum += ans[i];
        return sum;
    }

    public static void main(String[] args) {
        P135_3 p135_3 = new P135_3();
        System.out.println(p135_3.candy(new int[]{1, 3, 4, 5, 2}));
    }
}
