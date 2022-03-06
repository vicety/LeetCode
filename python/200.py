from typing import List


class Solution:

    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        vis = [[False for _ in range(n)] for _ in range(m)]

        ans = 0

        for i in range(m):
            for j in range(n):
                if not vis[i][j] and grid[i][j] == '1':
                    ans += 1
                    self.dfs(grid, i, j, m, n, vis)

        return ans

    def dfs(self, grid, y, x, m, n, vis):
        if not self.valid(m, n, y, x) or vis[y][x] or grid[y][x] == '0':
            return
        vis[y][x] = True
        self.dfs(grid, y + 1, x, m, n, vis)
        self.dfs(grid, y - 1, x, m, n, vis)
        self.dfs(grid, y, x + 1, m, n, vis)
        self.dfs(grid, y, x - 1, m, n, vis)

    def valid(self, m, n, y, x):
        return 0 <= y < m and 0 <= x < n
