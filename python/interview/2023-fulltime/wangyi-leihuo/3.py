import sys


class Point:
    def __init__(self):
        self.hasGrass = True
        self.isBurning = False
        self.burningTime = 0
        self.canStillSpan = 0
        self.totalBurningTime = 0
        self.newGrassCnt = 0  # 火灭的第六回合长出来


W, H = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))  # y x
N = int(input())
food = []
lit = dict()
for _ in range(N):
    x, y, t = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
    food.append((x, y, t))
M = int(input())
for _ in range(M):
    x, y, t = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
    if lit.get(t) is None:
        lit[t] = []
    lit[t].append((x, y))

mp = [[Point() for _ in range(H)] for _ in range(W)]


def inBound(y, x):
    return 0 <= y < W and 0 <= x < H


deltaY = [-1, -1, -1, 0, 0, 1, 1, 1]
deltaX = [-1, 0, 1, -1, 1, -1, 0, 1]


def printMp():
    def ptToCh(pt):
        if pt.isBurning:
            return "+"
        elif pt.hasGrass:
            return "w"
        else:
            return "."

    buf = ""
    for y in range(W):
        for x in range(H):
            buf += ptToCh(mp[y][x]) + " "
        print(buf)
        buf = ""
    print()


for time in range(1, 140):
    toExecute = dict()
    for y in range(W):
        for x in range(H):
            pt = mp[y][x]
            if not pt.hasGrass and not pt.isBurning:
                if pt.newGrassCnt == 5:
                    toExecute[(y, x, 1)] = -1
                    # pt.newGrassCnt = 0
                    # pt.hasGrass = True
                else:
                    pt.newGrassCnt += 1
            elif pt.isBurning:
                if pt.burningTime == 3:
                    toExecute[(y, x, 2)] = -1
                    # pt.isBurning = False
                    # pt.burningTime = 0
                    # pt.canStillSpan = 0
                else:
                    pt.burningTime += 1
                    pt.totalBurningTime += 1
                    # try to span
                    if pt.canStillSpan != 0:
                        for i in range(8):
                            dy, dx = y + deltaY[i], x + deltaX[i]
                            if inBound(dy, dx) and mp[dy][dx].hasGrass:
                                if toExecute.get((dy, dx, 3)) is None:
                                    toExecute[(dy, dx, 3)] = pt.canStillSpan - 1
                                else:
                                    # print(toExecute[(dy, dx, 3)], pt.canStillSpan - 1)
                                    toExecute[(dy, dx, 3)] = max(toExecute[(dy, dx, 3)], pt.canStillSpan - 1)
                                # dstPt = mp[dy][dx]
                                # dstPt.hasGrass = False
                                # dstPt.isBurning = True
                                # dstPt.burningTime = 1
                                # dstPt.totalBurningTime += 1
                                # dstPt.canStillSpan = pt.canStillSpan - 1

    # print(toExecute)
    for (y, x, cmd), span in toExecute.items():
        pt = mp[y][x]
        if cmd == 1:
            pt.newGrassCnt = 0
            pt.hasGrass = True
        elif cmd == 2:
            pt.isBurning = False
            pt.burningTime = 0
            pt.canStillSpan = 0
        elif cmd == 3:
            pt.hasGrass = False
            pt.isBurning = True
            pt.burningTime = 1
            pt.totalBurningTime += 1
            pt.canStillSpan = span

    toExecute = []

    if lit.get(time) is not None:
        for y, x in lit[time]:
            if mp[y][x].hasGrass:
                mp[y][x].hasGrass = False
                mp[y][x].isBurning = True
                mp[y][x].burningTime = 1
                mp[y][x].canStillSpan = 5
                mp[y][x].totalBurningTime += 1
            elif mp[y][x].isBurning:
                mp[y][x].burningTime = 1
                mp[y][x].canStillSpan = 5
    # printMp()
    # print()

ans = 0
for y, x, t in food:
    pt = mp[y][x]
    if mp[y][x].totalBurningTime >= t:
        ans += 1
print(ans)
