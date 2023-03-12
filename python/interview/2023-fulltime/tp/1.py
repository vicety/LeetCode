from typing import List

# [0, 0, 0, 0, 1, 1, 1]

def solve(arr: List[int], K: int):
    onesFirst = dict()  # (start, len)
    onesEnd = dict()  # (end, len)
    zeros = []  # idx
    oneCnt = 0
    for i, num in enumerate(arr):
        if num == 0:
            if oneCnt > 0:
                onesFirst[i - oneCnt] = oneCnt
                onesEnd[i - 1] = oneCnt
                oneCnt = 0
            zeros.append(i)
        elif num == 1:
            oneCnt += 1
    if oneCnt > 0:
        i = len(arr)
        onesFirst[i - oneCnt] = oneCnt
        onesEnd[i - 1] = oneCnt

    if K >= len(zeros):
        return len(arr)

    ans = 0
    r = K - 1
    while r < len(zeros):
        l = r - K + 1
        ans = max(ans, zeros[r] - zeros[l] + 1 + onesEnd.get(zeros[l] - 1, 0) + onesFirst.get(zeros[r] + 1, 0))
        r += 1
    return ans
