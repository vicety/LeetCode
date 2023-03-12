# 有一个n*m的矩阵，初始时有一颗骰子在(0, 0)的位置，且点数1朝上

# 骰子方向不可变动，骰子每次只能移动到相邻位置，在移动骰子的时候需要将骰子向相应方向翻转一下

# （如果骰子初始位置1朝上3向左，向右一格移动到0，1后，则1向右3向上）

# 求骰子移动到（i，j）位置且点数1还是朝上，需要的最小步数

#   front
# l up r
#   back
#   opp

from queue import PriorityQueue
from typing import List


def solve(n, m, dsti, dstj, weight: List[List[int]]):
    stateTrans = dict()
    # front, l, up, r, back, opp
    # 上下左右
    stateTrans[3] = [4, 0, 3, 1]
    stateTrans[5] = [0, 4, 3, 1]

    # 上下左右
    di = [1, -1, 0, 0]
    dj = [0, 0, -1, 1]

    def validPos(nowi, nowj):
        return nowi >= 0 and nowi < n and nowj >= 0 and nowj < m

    vis = dict()
    vis1 = dict()
    q = PriorityQueue()
    q.put((0, 0, 0, 2, 0))
    q.put((0, dsti, dstj, 2, 1))

    def ingest(nowVis, opponentVis, nowi, nowj, step, up, frm):
        if nowVis.get((nowi, nowj, up)) is not None:
            return None
        nowVis.add[(nowi, nowj, up)] = step
        if nowi == dsti and nowj == dstj and up == 2:
            return step
        if opponentVis.get((nowi, nowj, up)) is not None:
            return step + opponentVis[(nowi, nowj, up)]
        for i in range(4):
            nxti, nxtj = nowi + di[i], nowj + dj[i]
            if validPos(nxti, nxtj):
                q.put((step + weight[nxti][nxtj], nxti, nxtj, stateTrans[up][i], frm))

    while len(q.queue):
        step, nowi, nowj, up, frm = q.get()
        if frm == 0:
            res = ingest(vis, vis1, nowi, nowj, step, up, frm)
            if not res:
                continue
            else:
                return res
        else:
            ingest(vis1, vis, nowi, nowj, step, up, frm)

    return -1
