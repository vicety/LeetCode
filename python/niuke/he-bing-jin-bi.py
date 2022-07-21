import sys

n = int(sys.stdin.readline())
nums_str = sys.stdin.readline().strip().split()
nums = list(map(lambda t: int(t), nums_str))


def solve():
    if n == 1:
        print(0)
        return

    prefix = [0] * n
    cur = 0
    for i in range(n):
        cur += nums[i]
        prefix[i] = cur

    dp = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(0, n):
        dp[i][i] = nums[i]

    for i in range(1, n):
        for j in range(n):
            if j + i >= n:
                continue
            # if j+2 >= n:
                # dp[j][j+i] =
            dp[j][j + i] = min(nums[j] + 2 * dp[j + 1][j + i],
                               (nums[j] + nums[j + 1]) * 2 + dp[j + 2][j + i] * 2)
    print(dp[0][n - 1])


solve()
