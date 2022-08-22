
import sys

n_m = sys.stdin.readline().strip().split()
n = int(n_m[0])
m = int(n_m[1])

nums_str = sys.stdin.readline().strip().split()
nums = list(map(lambda t: int(t), nums_str))

weight = [0] * n
acc = [0] * n

ans = 0

for i in range(m):
    nums_str = sys.stdin.readline().strip().split()
    ops = list(map(lambda t: int(t), nums_str))
    l = ops[1]
    r = ops[2]
    if ops[0] == 1:
        for i in range(l-1, r):
            ans += acc[i]
            weight[i] += 1
    else:
        k = ops[3]
        for i in range(l-1, r):
            acc[i] += k

weight.sort()
nums.sort()
for i in range(len(nums)):
    ans += weight[i] * nums[i]

print(ans)