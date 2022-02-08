import time
import math


def run(N):
    sum = 0
    for i in range(N):
        sum += 1


start = time.time()
run(1000000000)  # 10^8 2.3s
print(time.time() - start)
