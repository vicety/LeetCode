a, b, x, y = list(map(int, input().split(' ')))


def solve():
    dp = [[99999 for _ in range(b + 1)] for _ in range(a + 1)]
    for i in range(1, x + 1):
        if i <= a:
            dp[i][0] = 1
        if i <= b:
            dp[0][i] = 1
    for i in range(y + 1):
        for j in range(y + 1):
            if i <= a and j <= b:
                dp[i][j] = 1

    dp[0][0] = 0

    for i in range(1, a + 1):
        for j in range(1, b + 1):
            if i - x < 0:
                dp[i][j] = min(dp[i][j], dp[0][j] + 1)
            else:
                dp[i][j] = min(dp[i][j], dp[i - x][j] + 1)
            if j - x < 0:
                dp[i][j] = min(dp[i][j], dp[i][0] + 1)
            else:
                dp[i][j] = min(dp[i][j], dp[i][j - x] + 1)

            if i - y < 0 and j - y < 0:
                dp[i][j] = 1
            elif i - y < 0:
                dp[i][j] = min(dp[i][j], dp[0][j - y] + 1)
            elif j - y < 0:
                dp[i][j] = min(dp[i][j], dp[i - y][0] + 1)
            else:
                dp[i][j] = min(dp[i][j], dp[i - y][j - y] + 1)

    return dp[a][b]

print(solve())
