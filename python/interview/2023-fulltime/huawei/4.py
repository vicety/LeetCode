from queue import PriorityQueue

T = int(input())
stat = dict()
for _ in range(T):
    word = input()
    stat[word] = stat.get(word, 0) + 1

N = int(input())
q = PriorityQueue()

for k, v in stat.items():
    if len(q.queue) < N:
        q.put((v, k))
    elif len(q.queue) == N and v > q.queue[0][0]:
        q.put((v, k))
        q.get()

ans = []
while len(q.queue) > 0:
    ans.append(q.get())

# (-freq, word abc)
ans = sorted(list(map(lambda x: (-x[0], x[1]), ans)))
for item in ans:
    print(item[1])

# 5
# 3
# 1
# 2
# 1
# 3
# 2