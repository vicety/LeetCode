package com.company.leetCode;

import java.util.Arrays;

public class P304 {
    class NumMatrix {

        int[][] prefix;

        public NumMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0) return;
            int m = matrix.length;
            int n = matrix[0].length;
            prefix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) prefix[i][j] = matrix[i][j];
                    else if (i == 0) prefix[i][j] = prefix[i][j - 1] + matrix[i][j];
                    else if (j == 0) prefix[i][j] = prefix[i - 1][j] + matrix[i][j];
                    else prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + matrix[i][j];
                }
            }
            System.out.println(Arrays.deepToString(prefix));
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) return prefix[row2][col2];
            else if (row1 == 0) return prefix[row2][col2] - prefix[row2][col1 - 1];
            else if (col1 == 0) return prefix[row2][col2] - prefix[row1 - 1][col2];
            else
                return prefix[row2][col2] - prefix[row1 - 1][col2] - prefix[row2][col1 - 1] + prefix[row1 - 1][col1 - 1];
        }
    }
}
