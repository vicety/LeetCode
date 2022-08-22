n, m = list(map(int, input().split(' ')))
mp = []
for _ in range(n):
    mp.append(list(map(int, input().split(' '))))

dp = [[float('inf') for _ in range(m)] for _ in range(n)]

dp[0][0] = 0

for i in range(1, m):
    if mp[0][i] == mp[0][i - 1]:
        dp[0][i] = dp[0][i - 1] + 1
    else:
        dp[0][i] = dp[0][i - 1] + 2

for i in range(1, n):
    for j in range(m):
        if mp[i][j] == mp[i - 1][j]:
            dp[i][j] = min(dp[i][j], dp[i - 1][j] + 1)
        else:
            dp[i][j] = min(dp[i][j], dp[i - 1][j] + 2)

    for j in range(m):
        if j != 0:
            if mp[i][j] == mp[i][j - 1]:
                dp[i][j] = min(dp[i][j], dp[i][j - 1] + 1)
            else:
                dp[i][j] = min(dp[i][j], dp[i][j - 1] + 2)

    for j in range(m - 1, -1, -1):
        if j != m - 1:
            if mp[i][j] == mp[i][j + 1]:
                dp[i][j] = min(dp[i][j], dp[i][j + 1] + 1)
            else:
                dp[i][j] = min(dp[i][j], dp[i][j + 1] + 2)

print(dp[n - 1][m - 1])
