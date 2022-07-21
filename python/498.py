from typing import List


class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        y1, x1 = -2, 0
        y2, x2 = 0, -1
        m = len(mat)
        n = len(mat[0])

        ans = []
        while True:
            y1, x1 = self.next1(y1, x1, m, n)
            if y1 is None:
                return ans
            nowy, nowx = y1, x1
            while nowy >= 0 and nowx < n:
                ans.append(mat[nowy][nowx])
                nowy -= 1
                nowx += 1

            y2, x2 = self.next2(y2, x2, m, n)
            if y2 is None:
                return ans
            nowy, nowx = y2, x2
            while nowy < m and nowx >= 0:
                ans.append(mat[nowy][nowx])
                nowy += 1
                nowx -= 1

    def next1(self, y1, x1, m, n):
        if y1 + 2 < m:
            return y1 + 2, x1
        if y1 + 2 == m:
            if x1 + 1 < n:
                return y1 + 1, x1 + 1
            return None, None
        if x1 + 2 < n:
            return y1, x1 + 2
        return None, None

    def next2(self, y2, x2, m, n):
        if x2 + 2 < n:
            return y2, x2 + 2
        if x2 + 2 == n:
            if y2 + 1 < m:
                return y2 + 1, x2 + 1
            return None, None
        if y2 + 2 < m:
            return y2 + 2, x2
        return None, None

# 1 2 3
# 4 5 6
