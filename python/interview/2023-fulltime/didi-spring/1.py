n, m, p = map(int, input().split())

# n 个礼物，分配到 m 个箱子，箱子的价值为其中礼物数量的平方，给出字典序最小，且总价值为 p 的分配方案，没有则打印 -1

def dfs(nowN, nowM, nowP, path):
    if nowM == 0 and nowP == p:
        return path
    if nowM == 0:
        return None
    for i in range(1, nowN - nowM + 2):
        path.append(i)
        tmp = dfs(nowN - i, nowM - 1, nowP + i ** 2, path)
        if tmp is not None:
            return tmp
        path.pop()
    return None


ans = dfs(n, m, 0, [])
if ans is None:
    print(-1)
else:
    print(" ".join(map(str, ans)))
