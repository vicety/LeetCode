import queue

n0 = int(input())

MAX = 99999


def valid(y, x, n, m, k, mp):
    if y < 0 or y >= n or x < 0 or x >= m:
        return False
    if mp[y][x] == "W":
        return False
    if mp[y][x] == "M" and k == 0:
        return False
    return True


for _ in range(n0):
    n, m, k = list(map(int, input().split(' ')))
    mp = [['-' for _ in range(m)] for _ in range(n)]
    dist = [[MAX for _ in range(m)] for _ in range(n)]
    vis = dict()  # i, j, n
    sty = -1
    stx = -1
    for i in range(n):
        s = input()
        for j, c in enumerate(s):
            mp[i][j] = c
            if c == "S":
                sty = i
                stx = j

    # dist[sty][stx] = 0

    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]

    q = queue.PriorityQueue()
    q.put((1, sty, stx, k))
    found = False

    while len(q.queue):
        nnow, y, x, know = q.get()
        if mp[y][x] == "E":
            found = True
            print(nnow)
            break

        if dist[y][x] < nnow:
            continue
        if dist[y][x] == nnow and vis.get((y, x)) is not None and know <= vis.get((y, x)):
            continue
        dist[y][x] = min(dist[y][x], nnow)
        vis[(y, x)] = know

        if know == 0:
            continue

        for j in range(know, 0, -1):
            for i in range(4):
                dsty = y + dy[i]
                dstx = x + dx[i]
                if valid(dsty, dstx, n, m, j - 1, mp):  # 走一步合法
                    q.put((nnow, dsty, dstx, j - 1))
                    if mp[dsty][dstx] != "M":
                        q.put((nnow + 1, dsty, dstx, k))

    if not found:
        print("-1")

# 1
# 1 5 4
# SMMME

# 3
# 1 5 4
# SMMME
# 1 5 3
# SMMME
# 3 9 3
# M-M-M-M-M
# SWWWWWWWE
# --M-M-M-M