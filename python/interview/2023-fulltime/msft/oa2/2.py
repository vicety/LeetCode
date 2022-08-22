def solution(X, Y):
    mod = int(1e9 + 7)
    # write your code in Python (Python 3.6)
    di = dict()
    for i in range(len(X)):
        xi, yi = X[i], Y[i]
        if xi >= yi:
            continue
        ggcd = gcd(xi, yi)
        xi /= ggcd
        yi /= ggcd
        if di.get((xi, yi)) is None:
            di[(xi, yi)] = 0
        di[(xi, yi)] += 1
    ans = 0
    halfCnt = di.get((1, 2), 0)
    ans += halfCnt * (halfCnt - 1) // 2  # C_halfCnt_2
    ans %= mod
    for (a, b), v in di.items():
        if a * 2 >= b:
            continue
        ans = ans + (v * di.get((b - a, b), 0)) % mod
    return ans


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


print(solution([1, 1, 2], [3, 2, 3]))
print(solution([1, 1, 1], [2, 2, 2]))
print(solution([1, 2, 3, 1, 2, 12, 8, 4], [5, 10, 15, 2, 4, 15, 10, 5]))
