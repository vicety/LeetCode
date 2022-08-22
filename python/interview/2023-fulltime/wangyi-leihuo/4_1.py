import sys

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

def inBound(y, x):
    return 0 <= y < N and 0 <= x < M

cyclePoint = set()
