import math
import sys

#

# If you need to import additional packages or classes, please import here.

def func():
    m, n = map(lambda x: int(x), sys.stdin.readline().strip().split())

    dp = [0] * 200000
    dp[0] = 1
    ssum = 0
    for now in range(1, m + 1):
        ssum += dp[now - 1]
        prev = now - n - 1
        if prev >= 0:
            ssum -= dp[prev]
        dp[now] = ssum
        # for prev in range(max(now - n, 0), now):
        #     dp[now] += dp[prev]

    print(dp[m])
    # solve(3, 2) = solve(2,2)+solve(1,2)

    # please define the python3 input here. For example: a,b = map(int, input().strip().split())
    # please finish the function body here.
    # please define the python3 output here. For example: print().


if __name__ == "__main__":
    func()
