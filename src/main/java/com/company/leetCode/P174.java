package com.company.leetCode;

import java.util.Arrays;

public class P174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (col < n - 1)
                    dp[row][col] = Math.min(dp[row][col],
                            dungeon[row][col] > dp[row][col + 1] - 1 ? 1 : dp[row][col + 1] - dungeon[row][col]);
                if (row < m - 1)
                    dp[row][col] = Math.min(dp[row][col],
                            dungeon[row][col] > dp[row + 1][col] - 1 ? 1 : dp[row + 1][col] - dungeon[row][col]);
            }
        }
        return dp[0][0];
    }
}
