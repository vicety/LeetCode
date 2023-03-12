# 1 1
# 2 1
# 3 2
# 4 1
# 5 2
# 6 2
# 7 3

from queue import PriorityQueue

pq = PriorityQueue()

n, k = list(map(int, input().split(' ')))
arr = list(map(int, input().split(' ')))


def operate(num):
    cnt = 0
    for i in range(33):
        if (num & (1 << i)) > 0:
            cnt += 1
    return cnt


for num in arr:
    cnt = operate(num)
    diff = num - cnt
    pq.put((-diff, num))

ans = sum(arr)

for _ in range(k):
    revDiff, num = pq.get()
    ans += revDiff
    newNum = num + revDiff
    cnt = operate(newNum)
    pq.put((cnt - newNum, newNum))

print(ans)