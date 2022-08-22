import sys

# i+k-3j=0 无序

n = int(input())
nums = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))

# from first, include current index
diStat = dict()
di = dict()
for i, num in enumerate(nums):
    if di.get(num) is None:
        di[num] = 0
    di[num] += 1
    diStat[i] = di.copy()
# print(diStat)

ans = 0
for i in range(n):
    for k in range(i + 2, n):
        ai, ak = nums[i], nums[k]
        if (ai + ak) % 3 != 0:
            continue
        target = (ai + ak) // 3
        ans += diStat[k - 1].get(target, 0) - diStat[i].get(target, 0)
print(ans)
