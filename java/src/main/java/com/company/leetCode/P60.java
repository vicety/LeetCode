package com.company.leetCode;

public class P60 {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] fact = new int[10];
        fact[0] = 1;
        for (int i = 1; i <= 9; i++) {
            fact[i] = fact[i - 1] * i;
        }
        fact[0] = 0;
        k -= 1;
        int[] vis = new int[10];
        for (int i = n; i >= 1; i--) {
            int t;
            if (i == 1) t = 0;
            else {
                t = k / fact[i - 1];
                k = k % fact[i - 1];
            }
            int cnt = -1;
            for (int j = 1; j <= n; j++)
                if (vis[j] == 0) {
                    cnt++;
                    if (cnt == t) {
                        vis[j] = 1;
                        sb.append((char) (j + '0'));
                        break;
                    }
                }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P60 p60 = new P60();
        System.out.println(p60.getPermutation(1, 1));
    }
}
