package com.company.leetCode;

public class P200 {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    cnt++;
                    dfs(vis, i, j, grid);
                }
            }
        }
        return cnt;
    }

    private void dfs(int[][] vis, int y, int x, char[][] grid) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length
                || vis[y][x] == 1 || grid[y][x] == '0') return;
        vis[y][x] = 1;
        dfs(vis, y + 1, x, grid);
        dfs(vis, y, x + 1, grid);
        dfs(vis, y - 1, x, grid);
        dfs(vis, y, x - 1, grid);
    }
}
