# all even or all odd
import math
import sys

n = int(sys.stdin.readline().strip())
line = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))

even = 0
odd = 0
for num in line:
    if num % 2 == 0:
        even += 1
    else:
        odd += 1

ans = 0
if even >= 2:
    ans = (ans + (2 ** even - even - 1)) % (int(1e9) + 7)
if odd >= 2:
    ans = (ans + (2 ** odd - odd - 1)) % (int(1e9) + 7)

print(ans)
