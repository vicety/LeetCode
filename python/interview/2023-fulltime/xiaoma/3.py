n = int(input())
s = input()

from queue import Queue

pQueue = Queue()
oQueue = Queue()
nQueue = Queue()
yQueue = Queue()

for i, c in enumerate(s):
    if c == 'p':
        pQueue.put(i)
    elif c == 'o':
        oQueue.put(i)
    elif c == 'n':
        nQueue.put(i)
    elif c == 'y':
        yQueue.put(i)

ans = 0
prev = -1
while not pQueue.empty() and not oQueue.empty() and not nQueue.empty() and not yQueue.empty():
    now = pQueue.get()
    while not oQueue.empty() and oQueue.queue[0] <= now:
        oQueue.get()
    if oQueue.empty():
        break
    now = oQueue.get()

    while not nQueue.empty() and nQueue.queue[0] <= now:
        nQueue.get()
    if nQueue.empty():
        break
    now = nQueue.get()

    while not yQueue.empty() and yQueue.queue[0] <= now:
        yQueue.get()
    if yQueue.empty():
        break
    now = yQueue.get()
    ans += 1

print(ans)
