import random


def solution(N):
    # write your code in Python 3.6
    if N == 0:
        return 0

    # solution for 9, 99, 999, 9999
    dp = {10: 1}

    now = 1
    n = 1
    for i in range(10):
        n += now
        n *= 10
        now *= 10
        dp[now * 10] = n

    return solve(N, dp)


def solve(N, dp):
    if N < 10:
        return 1 if N >= 1 else 0

    now = 10
    while N // now >= 10:
        now *= 10  # 54321 -> now = 10000
    m = N // now
    if m == 1:
        # 12 = solve(2) + dp[10] + 3 = 5
        return dp[now] + (N - now * m + 1) + solve(N - now * m, dp)
    else:
        # 32 = solve(2) + 3 * dp[10] + 10 = 14
        # 20 = solve(0) + 2 * dp[10] + 10 = 12
        return m * dp[now] + now + solve(N - now * m, dp)


# 54321 -> [01234]{0-9999} = 5 * {0-9999} + solve(4321)
# 14321 -> [0]{0-9999} = 1 * {0-9999} + 4322 + solve(4321)

# print(solution(0))


def solve1(N):
    s = ""
    for i in range(N + 1):
        s += str(i)

    # print(s)

    ans = 0
    for c in s:
        if c == '1':
            ans += 1

    return ans


for N in [0, 20, 1199]:  # 9 99 999 9999
    print(solve1(N), solution(N))

from collections import deque
from queue import PriorityQueue

q = PriorityQueue()
q.get()


# for N in range(10000):
#     rand = random.randint(0, 9999)
#     if solve1(rand) != solution(rand):
#         print(rand)
