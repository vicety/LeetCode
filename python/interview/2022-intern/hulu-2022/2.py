def solve():
    M, N = list(map(int, input().split(' ')))

    mp = []
    for _ in range(M):
        mp.append(input())

    A, B = list(map(int, input().split(' ')))
    pattern = []
    for _ in range(A):
        pattern.append(input())

    ans = 0
    for i in range(M):
        for j in range(N):
            if tryMatch(M, N, A, B, mp, i, j, pattern):
                ans += 1

    print(ans)


def tryMatch(M, N, A, B, mp, i, j, pattern):
    if i + A > M or j + B > N:
        return False
    for yInP in range(A):
        y = i + yInP
        for xInP in range(B):
            x = j + xInP
            if mp[y][x] != pattern[yInP][xInP]:
                return False

    return True


solve()
