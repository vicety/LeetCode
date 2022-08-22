import sys

n = int(input())
nums = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))

# min, max
minn = min(nums)
maxx = max(nums)


def solve(n, nums):
    # no space
    if maxx - minn <= 25:
        maxToValid = maxx - 90
        print(minn - maxToValid - 65 + 1)
    else:
        diff = minn - 32
        nums = list(map(lambda x: x - diff, nums))
        for item in nums:
            if (item < 65 and item != 32) or item > 90:
                print(0)
                return
        chars = list(map(lambda x: chr(x), nums))
        print("".join(chars))


solve(n, nums)
