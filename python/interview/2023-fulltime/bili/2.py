import sys

sys.stdin.readline().strip()
line = sys.stdin.readline().strip()


def solve():
    ans = 0
    l = 0
    r = 0
    for ch in line:
        if ch == ')':
            if r >= l:
                break
            r += 1
            if r == l:
                ans = r * 2
        else:
            l += 1

    print(ans)

solve()