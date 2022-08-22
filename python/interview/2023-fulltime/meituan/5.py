import sys

n = int(input())
nums = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
nums = [-1] + nums

# 1 -> 1
# 2 -> 1
# 3 -> 2
# 4 -> 3
# 5 -> 3
# 6,7 -> 4
# 8, 9 -> 5
ans = 0
for i in range(1, n + 1):
    now_sum = 0
    now = i
    while now:
        now_sum += nums[now]  # TODO: cache
        now //= 2
    ans = max(ans, now_sum)
print(ans)
