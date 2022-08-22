s = input()


def solve():
    dp = [0 for _ in range(len(s) + 1)]
    for i in range(len(s) - 2, -1, -1):
        if isRelated(s[i], s[i + 1]):
            dp[i] = max(score(s[i]) + score(s[i + 1]) + dp[i + 2], dp[i + 1])
        else:
            dp[i] = dp[i + 1]

    return dp[0]


def score(a):
    return ord(a) - ord('a') + 1


def isRelated(a, b):
    return abs(ord(a) - ord(b)) <= 1


print(solve())
