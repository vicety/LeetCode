package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P375_2 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        int tmp;
        for (int k = 1; k < n; k++) {
            for (int l = 1; l + k <= n; l++) {
                int r = l + k;
                tmp = Integer.MAX_VALUE;
                for (int i = l; i <= r; i++) {
                    int left = i - 1 > l ? dp[l][ i - 1] : 0;
                    int right = i + 1 < r ? dp[i + 1][r] : 0;
                    tmp = Math.min(tmp, Math.max(left, right) + i);
                }
                dp[l][r] = tmp;
            }
        }
        return dp[1][n];
    }
}
