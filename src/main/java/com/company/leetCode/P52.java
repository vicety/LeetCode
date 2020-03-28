package com.company.leetCode;

class P52 {

    private int ans;

    private int toX1(int x, int y) {
        return x + y;
    }

    private int toX2(int x, int y, int n) {
        return x + (n - 1 - y);
    }

    private void solve(int now, int n, int[] row, int[] col, int[] x1, int[] x2) {
        if (now == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++)
            if (col[i] == 0 && x1[toX1(now, i)] == 0 && x2[toX2(now, i, n)] == 0) {
                row[now] = i;
                col[i] = 1;
                x1[toX1(now, i)] = 1;
                x2[toX2(now, i, n)] = 1;
                solve(now + 1, n, row, col, x1, x2);
                col[i] = 0;
                x1[toX1(now, i)] = 0;
                x2[toX2(now, i, n)] = 0;
            }
    }

    public int totalNQueens(int n) {
        ans = 0;
        int[] row = new int[n];
        int[] col = new int[n];
        int[] x1 = new int[2 * n];
        int[] x2 = new int[2 * n];
        solve(0, n, row, col, x1, x2);
        return ans;
    }

    public static void main(String[] args) {
        P52 p52 = new P52();
        System.out.println(p52.totalNQueens(4));
    }
}