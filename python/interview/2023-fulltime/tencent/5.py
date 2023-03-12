n = int(input())
arr = list(map(int, input().split(' ')))

sm = sum(arr)


def solve():
    def search(idx, x, y, path, smm):
        if idx == len(arr):
            if smm == 0:
                print("{} {}".format(x, y))
                print(path)
                return True
            return False
        return search(idx + 1, x, y, path + "X", smm + arr[idx] * x) or search(idx + 1, x, y, path + "Y",
                                                                               smm + arr[idx] * y)

    # search(0, -1226, 1148, "", 0)

    for i in range(sm):
        baseX = sm // 2 - i
        baseY = sm - baseX
        if baseX < 0 or baseY > sm:
            print(-1)
            return

        comb = [(baseX, baseY), (-baseX, baseY), (baseX, -baseY), (-baseX, -baseY)]
        for bx, by in comb:
            # if bx == 1148:
            #     print("here")
            if search(0, bx, by, "", 0):
                return

    print(-1)
    return


solve()
