package com.company.leetCode;

public class P329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, dp, m, n, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int[][] dp, int m, int n, int y, int x) {

        if (dp[y][x] != 0) return dp[y][x];
        dp[y][x] = 1;
        int ans = 1;
        if (y + 1 < m && matrix[y][x] > matrix[y + 1][x]) ans = Math.max(ans, dfs(matrix, dp, m, n, y + 1, x) + 1);
        if (y - 1 >= 0 && matrix[y][x] > matrix[y - 1][x]) ans = Math.max(ans, dfs(matrix, dp, m, n, y - 1, x) + 1);
        if (x + 1 < n && matrix[y][x] > matrix[y][x + 1]) ans = Math.max(ans, dfs(matrix, dp, m, n, y, x + 1) + 1);
        if (x - 1 >= 0 && matrix[y][x] > matrix[y][x - 1]) ans = Math.max(ans, dfs(matrix, dp, m, n, y, x - 1) + 1);
        dp[y][x] = ans;
        return ans;
    }

    public static void main(String[] args) {
        P329 p329 = new P329();
        int[][] mat = new int[3][3];
        mat[0] = new int[]{1, 2, 3};
        mat[1] = new int[]{8, 9, 4};
        mat[2] = new int[]{7, 6, 5};
        System.out.println(p329.longestIncreasingPath(mat));
    }
}
