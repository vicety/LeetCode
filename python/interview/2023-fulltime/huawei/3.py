# If you need to import additional packages or classes, please import here.

import sys
from collections import deque

#
# class List:
#     def __init__(self):
#         self.val = -1
#         self.next = None
#
#
# class DQ:
#     def __init__(self):
#         self.head = List()
#         self.tail = self.head
#         self.sz = 0
#
#     def sz(self):
#         return self.sz
#
#     def pop(self):
#         self.sz -= 1
#         ret = self.head.next
#         self.head = self.head.next
#         return ret
#
#     def append(self, val):
#         self.sz += 1
#         li = List()
#         li.val = val
#         self.tail.next = li
#         self.tail = self.tail.next

# 拓扑排序执行并发有依赖任务，问最少需要时间

def func():
    nTask = int(sys.stdin.readline().strip())
    taskResourceUsageTime = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
    nDep = int(sys.stdin.readline().strip())
    deps = dict()
    depCnt = dict()
    for _ in range(nDep):
        frm, to = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))[::-1]  # to, from -> from, to
        depCnt[to] = depCnt.get(to, 0) + 1
        if deps.get(frm) is None:
            deps[frm] = []
        deps[frm].append(to)

    taskQ = deque()
    maxTime = 0
    for i in range(nTask):
        if depCnt.get(i, 0) == 0:
            taskQ.append((i, 0))  # taskId, startTime

    while len(taskQ):
        taskId, startTime = taskQ.popleft()
        endTime = startTime + taskResourceUsageTime[taskId]
        maxTime = max(maxTime, endTime)
        for to in deps.get(taskId, []):
            depCnt[to] -= 1
            if depCnt[to] == 0:
                taskQ.append((to, endTime))

    print(maxTime)

    # please define the python3 input here. For example: a,b = map(int, input().strip().split())
    # please finish the function body here.
    # please define the python3 output here. For example: print().


if __name__ == "__main__":
    func()


# 4
# 2 2 2 2
# 3
# 1 0
# 3 1
# 3 2

# 4
# 2 2 3 2
# 3
# 1 0
# 3 1
# 3 2

# 4
# 2 2 2 2
# 0