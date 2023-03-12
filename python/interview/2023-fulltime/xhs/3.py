import sys

n, m, k = sys.stdin.readline().strip().split()
st = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
ed = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
weight = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))

n = int(n)
m = int(m)
k = int(k)

graph = dict()
for i in range(m):
    if graph.get(st[i]) is None:
        graph[st[i]] = dict()
    if graph[st[i]].get(ed[i], 99999999999) > weight[i]:
        graph[st[i]][ed[i]] = weight[i]

    if graph.get(ed[i]) is None:
        graph[ed[i]] = dict()
    if graph[ed[i]].get(st[i], 99999999999) > weight[i]:
        graph[ed[i]][st[i]] = weight[i]


def solve():
    return dfs(1, k, 0, n, set())


def dfs(now, know, val, target, vis):
    if know == -1:
        return 9999999999
    if now == target:
        return val
    vis.add(now)
    dstkv = graph.get(now, dict())
    ans = 9999999999
    for dst, w in dstkv.items():
        if not (dst in vis):
            ans = min(ans, dfs(dst, know - 1, max(val, w), target, vis))
    vis.remove(now)
    return ans


print(solve())
# 1