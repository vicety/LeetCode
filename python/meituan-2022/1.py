import sys

n = int(input())
nums_str = sys.stdin.readline().strip().split()
nums = []
for s in nums_str:
    nums.append(int(s))

nums.sort()
last = None
ans = 0
for i in range(n):
    if last is None:
        last = nums[i]
        ans += 1
    elif nums[i] - last > 1:
        last = nums[i]
        ans += 1
    else:
        continue

print(ans)