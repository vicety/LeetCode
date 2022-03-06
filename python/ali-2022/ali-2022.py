import sys


def solve(n, t):
    # 3 +1 +2 +3
    # 4 +1 +3 +5
    # 5 1 4 7 10
    ans = 0
    s = 1
    for i in range(t+1):
        ans += s
        s += (n - 2)
    return ans


if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    ans = 0
    for i in range(n):
        line = sys.stdin.readline().strip()
        values = list(map(int, line.split()))
        ans += solve(values[0], values[1])
    print(ans)