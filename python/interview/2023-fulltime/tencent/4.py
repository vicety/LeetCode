l, r = list(map(int, input().split(' ')))

cntDi = dict()
now = 2
cnt = 1
for _ in range(50):
    cntDi[now] = cnt
    now *= 2
    cnt *= 2


def highBit(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    i = 1
    while i * 2 <= n:
        i *= 2
    return i


def getN(n):
    if n == 1:
        return 1
    if n == 2:
        return 0
    n -= 1
    hb = highBit(n)
    now = hb
    rev = False
    while n > 0:
        if now & n > 0:
            rev = not rev
            n -= now
        now //= 2
    return 0 if rev else 1


def prefix(N):
    n = N
    if n == 0:
        return 0
    if n == 1:
        return 1
    hb = highBit(n)
    now = hb
    ans = 0
    while n >= 2:
        if now & n > 0:
            ans += cntDi[now]
            n -= now
        now //= 2

    if N % 2 == 1:
        ans += getN(N)

    return ans

# 7 = di[4] + di[2] + getN(7) = 2 + 1 + 1 = 4
# 3 = di[2] + get(3) = 1 + 0 = 1

print(prefix(r) - prefix(l - 1))
