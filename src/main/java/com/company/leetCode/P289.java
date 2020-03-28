package com.company.leetCode;

public class P289 {
    private boolean get(int[][] board, int y, int x) {
        if (y < 0 || y >= board.length || x < 0 || x >= board[0].length) return false;
        return (board[y][x] & 1) == 1;
    }

    private int getCnt(int[][] board, int y, int x) {
        int cnt = 0;
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (i == y && j == x) continue;
                if (get(board, i, j)) cnt++;
            }
        }
        return cnt;
    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = getCnt(board, i, j);
                if (board[i][j] == 1 && (cnt >= 2 && cnt <= 3)) board[i][j] += 2;
                else if (board[i][j] == 0 && cnt == 3) board[i][j] += 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
