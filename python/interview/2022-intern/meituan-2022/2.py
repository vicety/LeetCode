'''
1. 完全翻转等于不翻转
2. 要翻转则必须利用，即允许中间一段不取，如 xxxyyxxyyyxx，等价于找两段最大
'''

import sys

n = int(input())
nums_str = sys.stdin.readline().strip().split()
nums = []
for s in nums_str:
    nums.append(int(s))

leftSum = []
leftMin = []
leftAcc = []

rightSum = [0] * len(nums)
rightMin = [0] * len(nums)
rightAcc = [0] * len(nums)

ans = float("-inf")
now = 0
nowMin = 0
for i in range(len(nums)):
    now += nums[i]
    leftSum.append(now)
    leftMin.append(nowMin)
    nowMin = min(nowMin, now)

leftMaxPrefix = [float("-inf")] * len(nums)  # max prefix that end with i
for i in range(len(nums)):
    leftMaxPrefix[i] = leftSum[i] - leftMin[i]
    ans = max(ans, leftMaxPrefix[i])

maxx = float("-inf")
for i in range(len(leftMaxPrefix)):  # max prefix till i
    maxx = max(maxx, leftMaxPrefix[i])
    leftAcc.append(maxx)

now = 0
nowMin = 0
for i in range(len(nums) - 1, -1, -1):
    now += nums[i]
    rightSum[i] = now
    rightMin[i] = nowMin
    nowMin = min(nowMin, now)

rightMaxPrefix = [float("-inf")] * len(nums)
for i in range(len(nums) - 1, -1, -1):
    rightMaxPrefix[i] = rightSum[i] - rightMin[i]
    ans = max(ans, rightMaxPrefix[i])

maxx = float("-inf")
for i in range(len(nums) - 1, -1, -1):
    maxx = max(maxx, rightMaxPrefix[i])
    rightAcc[i] = maxx

for i in range(1, len(nums)):
    ans = max(ans, leftAcc[i - 1] + rightAcc[i])

print(ans)
