# TODO: 线程阻塞状态？

import sys

line = sys.stdin.readline().strip()
last = ""
ans = 0
repeat = 1
for c in line:
    if c == last:
        repeat += 1
    else:
        if repeat > 1:
            ans += (repeat + 1) // 3
        repeat = 1
        last = c

if repeat > 1:
    ans += (repeat + 1) // 3

print(ans)

# ddd ddd
# 2 -> 1
# 3 -> 1
# 4 -> 1
# d dd d -> d r d
# 5 -> 2
# 6 -> 2
# 7 -> 2
# d dd d dd d -> d r d r d
# 8 -> 3
# d dd d dd d d -> d r d r d r
#


# d e rd
