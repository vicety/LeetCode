def solve(n):
    ans = []
    ansn = [float('inf')]

    def dfs(now, plan, ans, ansn):
        if now == 0:
            if len(plan) < ansn[0]:
                ansn[0] = len(plan)
                ans.clear()
                for item in plan:
                    ans.append(item)
                # print(ans)
            return
        for i in [1, 2, 5]:
            if now >= i:
                dfs(now - i, plan + [i], ans, ansn)

    dfs(n, [], ans, ansn)
    return ans


print(solve(23))
