# 500M 10^10 = 10G / 8 = 1.25G gg
import sys

# N * M
N, M = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))  # y x
P = int(input())
painted = set()
data = sys.stdin.readline().strip().split()
for d in data:
    y, x = d.split(",")
    y = int(y)
    x = int(x)
    painted.add((y, x))
Q = int(input())
query = []
data = sys.stdin.readline().strip().split()
for d in data:
    y, x = d.split(",")
    y = int(y)
    x = int(x)
    query.append((y, x))

mp = [[0 for _ in range(M)] for _ in range(N)]
for y, x in painted:
    mp[y][x] = 1

vis = [[False for _ in range(M)] for _ in range(N)]
start = set()
for i in range(M):
    start.add((0, i))
    start.add((N - 1, i))
for i in range(N):
    start.add((i, 0))
    start.add((i, M - 1))

deltaY = [-1, 0, 0, 1]
deltaX = [0, -1, 1, 0]


def inBound(y, x):
    return 0 <= y < N and 0 <= x < M


from queue import Queue


def bfs(y, x):
    q = Queue()
    q.put((y, x))
    while not q.empty():
        y, x = q.get()
        if vis[y][x] or mp[y][x] == 1:
            continue
        vis[y][x] = True
        for i in range(4):
            dy, dx = y + deltaY[i], x + deltaX[i]
            if inBound(dy, dx):
                q.put((dy, dx))


for y, x in start:
    bfs(y, x)

for y in range(N):
    for x in range(M):
        if not vis[y][x]:
            mp[y][x] = 1

buf = ""
for y, x in query:
    buf += str(mp[y][x])

print(buf)
