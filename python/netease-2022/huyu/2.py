n0 = int(input())


def dfs(pos_di, max_di, nowi, nowR, nowD, best):
    if nowi == 7:
        if nowR >= 100:
            best[0] = max(best[0], nowD)
        return

    if nowR >= 100:
        dfs(pos_di, max_di, nowi + 1, nowR, nowD + max_di[nowi], best)
    else:
        for i, p, r, d in pos_di[nowi]:
            dfs(pos_di, max_di, nowi + 1, nowR + r, nowD + d, best)


for _ in range(n0):
    n1 = int(input())
    pos_di = dict()
    max_di = dict()
    for i in range(1, 7):
        pos_di[i] = []

    maxRSum = 0
    for _ in range(n1):
        position, rate, dmg = list(map(int, input().split(' ')))
        # 10^6 3^6=1000 10^9

        li = pos_di[position]
        new_li = []
        for i, p, r, d in li:
            if r >= rate and d >= dmg:  # 如果存在任意一件优于当前的
                new_li = li
                break

        if not new_li:
            for i, p, r, d in li:
                if rate >= r and dmg >= d:  # 去除任何劣于当前的
                    continue
                else:
                    new_li.append((len(new_li), p, r, d))
            new_li.append((len(new_li), position, rate, dmg))

        maxd = max(list(map(lambda x: x[3], new_li)))

        pos_di[position] = new_li
        max_di[position] = maxd
        maxRSum += max(list(map(lambda x: x[2], new_li)))

    if maxRSum < 100:
        print("TAT")
    else:
        best = [-1]
        dfs(pos_di, max_di, 1, 0, 0, best)
        if best[0] == -1:
            print("TAT")
        else:
            print(best[0])
