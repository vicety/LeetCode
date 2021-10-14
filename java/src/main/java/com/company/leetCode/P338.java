package com.company.leetCode;

import java.util.Arrays;

public class P338 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        if (num == 0) return ans;
        ans[1] = 1;
        if (num == 1) {
            return ans;
        }
        int now = 2, st = 0, ed = 2;
        while (now <= num) {
            if (st == ed) {
                ed = now;
                st = 0;
                ans[now] = 1;
            } else {
                ans[now] = ans[st] + 1;
            }
            st++;
            now++;
        }
        return ans;
    }

    public static void main(String[] args) {
        P338 p338 = new P338();
        System.out.println(Arrays.toString(p338.countBits(2)));
    }
}
