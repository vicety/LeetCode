N, M, K = list(map(int, input().split(' ')))
nums = list(map(int, input().split(' ')))


def solve():
    nowSum = 0
    minusCnt = 0
    ans = 0
    retry = []

    arr = []
    for i in range(1, N):
        arr = nums[:i]

        for i, num in enumerate(arr):
            if num < 0:
                minusCnt += 1
                if minusCnt >= M:
                    nowSum = 0
                    continue
            nowSum += num
            if nowSum <= 0:
                nowSum = 0
                minusCnt = 0
            if nowSum <= K:
                ans = max(ans, nowSum)

    print(ans)


solve()
