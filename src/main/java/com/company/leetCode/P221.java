package com.company.leetCode;

import java.util.Arrays;

public class P221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    ans = Math.max(ans, dp[i][j]);
                    continue;
                }
                int right = dp[i][j + 1];
                int below = dp[i + 1][j];
                int possibleSize = Math.min(right, below) + 1;
                if (matrix[i][j] == '1' && matrix[i + possibleSize - 1][j + possibleSize - 1] == '1') {
                    dp[i][j] = possibleSize;

                } else if(matrix[i][j] == '1') {
                    if(possibleSize == 0) dp[i][j] = 1;
                    else dp[i][j] = possibleSize - 1;
                }
                else dp[i][j] = 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println("matrix = " + Arrays.deepToString(dp));
        return ans * ans;
    }
}
