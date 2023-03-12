n, m = list(map(int, input().strip().split()))
#
# dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
#
# mod = int(1e9) + 7
#
# # dp[2][1] = 1
# dp[2][2] = 2
# for i in range(3, m + 1):
#     # 与现有的
#     dp[2][i] = 5 * dp[2][i - 1] % mod
#
# for i in range(3, n + 1):
#     for j in range(2, m + 1):
#
# print(dp[n][m])

# 1 1 1 # 破坏
# 0 0 1 # 破坏
# 0 1 2 # 顺着
# 1 0 1 # 破坏

# 0 1
# 1 0
#
# 1 0
# 0 1

def solve(n, m):
    if n == 2 and m == 2:
        return 2



print(solve(n, m))