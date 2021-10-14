package com.company.leetCode;

public class P130 {
    // bfs看块中有没有边界点
    private boolean validLocation(int y, int x, int m, int n) {
        return y >= 0 && y < m && x >= 0 && x < n;
    }

    private void dfs(int y, int x, int m, int n, boolean[][] vis, char[][] board) {
        vis[y][x] = true;
        if (validLocation(y + 1, x, m, n) && !vis[y + 1][x] && board[y + 1][x] == 'O') dfs(y + 1, x, m, n, vis, board);
        if (validLocation(y, x + 1, m, n) && !vis[y][x + 1] && board[y][x + 1] == 'O') dfs(y, x + 1, m, n, vis, board);
        if (validLocation(y - 1, x, m, n) && !vis[y - 1][x] && board[y - 1][x] == 'O') dfs(y - 1, x, m, n, vis, board);
        if (validLocation(y, x - 1, m, n) && !vis[y][x - 1] && board[y][x - 1] == 'O') dfs(y, x - 1, m, n, vis, board);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            if(board[0][i] == 'O' && !vis[0][i]) dfs(0, i, m, n, vis, board);
            if(board[m - 1][i] == 'O' && !vis[m - 1][i]) dfs(m - 1, i, m, n, vis, board);
        }
        for(int i = 1; i < m - 1; i++) {
            if(board[i][0] == 'O' && !vis[i][0]) dfs(i, 0, m, n, vis, board);
            if(board[i][n - 1] == 'O' && !vis[i][n - 1]) dfs(i, n - 1, m, n, vis, board);
        }

        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if(board[y][x] == 'O' && !vis[y][x]) board[y][x] = 'X';
            }
        }
    }
}
