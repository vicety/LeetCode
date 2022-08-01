N, M, K = list(map(int, input().split(' ')))
nums = list(map(int, input().split(' ')))


def solve():
    nowSum = 0
    minusCnt = 0
    ans = 0
    for num in nums:
        if num < 0:
            minusCnt += 1
            if minusCnt >= M:
                nowSum = 0
                continue
        nowSum += num
        if nowSum >= K:
            print(K)
            return
        if nowSum <= 0:
            nowSum = 0
            minusCnt = 0
        if nowSum <= K:
            ans = max(ans, nowSum)

    print(ans)


solve()
