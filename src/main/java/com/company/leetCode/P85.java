package com.company.leetCode;

public class P85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        right[m - 1][n - 1] = matrix[m - 1][n - 1] == '1' ? 1 : 0;
        down[m - 1][n - 1] = matrix[m - 1][n - 1] == '1' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (matrix[m - 1][i] == '1') {
                right[m - 1][i] = right[m - 1][i + 1] + 1;
                down[m - 1][i] = 1;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            if (matrix[i][n - 1] == '1') {
                right[i][n - 1] = 1;
                down[i][n - 1] = down[i + 1][n - 1] + 1;
            }
        }
        int ans = 0;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[i][j] = Math.min(right[i + 1][j], right[i][j + 1] + 1);
                    down[i][j] = Math.min(down[i][j + 1], down[i + 1][j] + 1);
                    ans = Math.max(ans, right[i][j] * down[i][j]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("(%d, %d)", right[i][j], down[i][j]));
            }
            System.out.println();
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
