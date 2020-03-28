package com.bytedance.leetcode;

public class P378_3 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[m - 1][n - 1];
        // find the first value that makes number of values geq than that value bigger or equal than k
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int leq = leqElementNumber(matrix, mid, m, n);
            if (leq >= k) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    private int leqElementNumber(int[][] matrix, int target, int m, int n) {
        int y = m - 1;
        int x = 0;
        int ans = 0;
        while (y >= 0 && x < n) {
            while (y >= 0 && matrix[y][x] > target) y--;
            if(y < 0) break;
            ans += y + 1;
            x++;
        }
        return ans;
    }
}
