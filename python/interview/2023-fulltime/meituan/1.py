import sys

n, t = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
nums = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
nums.sort()
ptr = 0
now_time = 0
manual = 0
magic = 0
while ptr < len(nums):
    if nums[ptr] - now_time < t:
        magic += 1
    else:
        now_time += t
        manual += 1
    ptr += 1
print(magic)
