package com.company.leetCode;

public class P73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int right = 0;
        int down = 0;
        if (matrix[0][0] == 0) {
            right = 1;
            down = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) right = 1;
                    else if (j == 0) down = 1;
                    else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) matrix[i][j] = 0;
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) matrix[j][i] = 0;
            }
        }
        if (right == 1) {
            for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
        }
        if (down == 1) {
            for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        }
    }
}
