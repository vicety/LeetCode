from typing import List


# [1, -2, 3, -4, -5]
def solve(arr: List[int]):
    nowPos = None
    nowNeg = None
    metNeg = False
    ans = float('-inf')

    for num in arr:
        if num == 0:
            nowPos = None
            nowNeg = None
            metNeg = False
            continue

        # first number
        if nowPos is None:
            nowPos = num
        else:
            nowPos *= num

        # ignore first negative
        if not metNeg and num < 0:
            metNeg = True
        elif metNeg:
            if nowNeg is None:
                nowNeg = num
            else:
                nowNeg *= num

        if nowPos:
            ans = max(ans, nowPos)
        if nowNeg:
            ans = max(ans, nowNeg)

    return ans


#   3
# 1   3

def solve(root):
    ans = []  # (num, freq)
    last = None

    def solveInner(now):
        nonlocal last
        nonlocal ans

        if not now:
            return

        if now.val != last:
            last = now.val
            res = calculate(now, now.val)
            if len(ans) == 0 or res > ans[0][1]:
                ans = [(now.val, res)]
            elif res == ans[0][1]:
                ans.append((now.val, res))
        solveInner(now.left)
        solveInner(now.right)

    def calculate(now, num):
        if not now:
            return 0
        if now.val == num:
            return 1 + calculate(now.left, num) + calculate(now.right, num)
        return 0

    solveInner(root)
    return list(map(lambda x: x[0], ans))
