package com.company.leetCode;

public class P48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int x = 0; x < n / 2; x++) {
            for (int y = 0; y <= n / 2; y++) {
                if (n % 2 == 1 && y == n / 2) continue;
                int tmp = matrix[x][y];
                matrix[x][y] = matrix[n - 1 - y][x];
                matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y];
                matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];
                matrix[y][n - 1 - x] = tmp;
            }
        }
    }
}
