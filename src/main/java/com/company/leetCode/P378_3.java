package com.company.leetCode;

public class P378_3 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[m - 1][n - 1];
        // find the first value that makes number of values geq than that value bigger or equal than k
        while (l <= r) {

        }
        return -1;
    }
}
