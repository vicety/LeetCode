from typing import List
import queue


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        ans = [[float('inf') for _ in range(n)] for _ in range(m)]

        q = queue.Queue()
        vis = set()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    ans[i][j] = 0
                    q.put((i, j))

        while q.queue:
            i, j = q.get()
            if (i, j) in vis or not self.valid_point(m, n, i, j):
                continue

            vis.add((i, j))
            self.setMin(ans, m, n, i + 1, j, ans[i][j] + 1)
            self.setMin(ans, m, n, i - 1, j, ans[i][j] + 1)
            self.setMin(ans, m, n, i, j + 1, ans[i][j] + 1)
            self.setMin(ans, m, n, i, j - 1, ans[i][j] + 1)
            q.put((i + 1, j))
            q.put((i - 1, j))
            q.put((i, j + 1))
            q.put((i, j - 1))

        return ans

    def valid_point(self, m, n, i, j):
        return 0 <= i < m and 0 <= j < n

    def setMin(self, mat, m, n, i, j, val):
        if 0 <= i < m and 0 <= j < n:
            mat[i][j] = min(mat[i][j], val)


s = Solution()
print(s.updateMatrix([[0, 0, 0], [0, 1, 0], [1, 1, 1]]))

from collections import deque
q = deque()


