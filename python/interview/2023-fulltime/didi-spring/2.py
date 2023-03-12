# 2 ** 10 1024

n, q = map(int, input().split())
qlist = list(map(int, input().split()))

mp = [[0 for _ in range(1025)] for _ in range(1025)]

threshold = 1026

def doMark(i, j):
    if i >= threshold:
        return
    mp[i][j] = 1


def mark(lu, rd, nowN):
    if nowN == n + 1:
        return
    u, l = lu[0], lu[1]
    d, r = rd[0], rd[1]
    umid = (lu[0] + rd[0]) // 2
    lmid = (lu[1] + rd[1]) // 2

    if u >= threshold:
        return

    if nowN % 2 == 1:
        if u < threshold:
            for i in range(u, umid + 1):
                for j in range(l, lmid + 1):
                    doMark(i, j)
        if umid + 1 < threshold:
            for i in range(umid + 1, d + 1):
                for j in range(lmid + 1, r + 1):
                    doMark(i, j)
        mark((u, lmid + 1), (umid, r), nowN + 1)
        mark((umid + 1, l), (d, lmid), nowN + 1)
    else:
        if u < threshold:
            for i in range(u, umid + 1):
                for j in range(lmid + 1, r + 1):
                    doMark(i, j)
        if umid + 1 < threshold:
            for i in range(umid + 1, d + 1):
                for j in range(l, lmid + 1):
                    doMark(i, j)
        mark((u, l), (umid, lmid), nowN + 1)
        mark((umid + 1, lmid + 1), (d, r), nowN + 1)


mark((0, 0), (2 ** n - 1, 2 ** n - 1), 1)

for row in qlist:
    ans = ""
    for i in range(2 ** n):
        ans += "B" if mp[row - 1][i] == 1 else "W"
    print(ans)

# 0 1 -> 0
# 2 3 -> 2
#
# 0 3 -> 1
# 4 7 -> 5
