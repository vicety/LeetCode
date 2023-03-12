n, m = input().strip().split()
n = int(n)
m = int(m)

mp = [["" for _ in range(m)] for _ in range(n)]
vis = [[False for _ in range(m)] for _ in range(n)]

for i in range(n):
    line = input()
    for j, c in enumerate(line):
        mp[i][j] = line[j]

import queue

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

ban = dict()
ban["r"] = "d"
ban["e"] = "r"
ban["d"] = "e"


def solve():
    if m == 1 and n == 1:
        return 0

    vis[0][0] = True
    q = queue.Queue()
    q.put((0, 0, 0))
    while not q.empty():
        nowy, nowx, nown = q.get()
        nowc = mp[nowy][nowx]
        for i in range(4):
            nxty, nxtx = nowy + dy[i], nowx + dx[i]
            if nxty >= 0 and nxty < n and nxtx >= 0 and nxtx < m and not vis[nxty][nxtx]:
                nxtc = mp[nxty][nxtx]
                if ban[nowc] == nxtc:
                    continue
                vis[nxty][nxtx] = True
                q.put((nxty, nxtx, nown + 1))
                if nxty == n - 1 and nxtx == m - 1:
                    return nown + 1
    return -1


print(solve())
