n, k = list(map(lambda x: int(x), input().split()))
arr = list(map(lambda x: int(x), input().split()))

from queue import PriorityQueue

q = PriorityQueue()

idxToNode = dict()


# for i, num in enumerate(arr):
#     q.put((num, i))


class ListNode:
    def __init__(self):
        self.idx = None
        # self.val = None
        self.next = None
        self.prev = None


dummy = ListNode()
now = dummy
tail = None
for i in range(len(arr)):
    now.next = ListNode()
    q.put((arr[i], i))
    idxToNode[i] = now.next
    now.next.prev = now
    now.next.idx = i
    now = now.next
    tail = now

tail.next = dummy.next
tail.next.prev = tail
head = dummy.next

rest_people = n
now = tail


def solve(rest_people, k, tail):
    now_sum = 0
    while True:
        require_one, idx = q.get()
        require_one -= now_sum
        minNode = idxToNode[idx]
        require_all = require_one * rest_people
        if k <= require_all:
            k %= rest_people
            now = tail
            while k > 0:
                now = now.next
                k -= 1
            return now.idx + 1
        now_sum += require_one
        k -= require_all
        # print("remove {}".format(minNode.idx))
        rest_people -= 1
        minNode.next.prev = minNode.prev
        minNode.prev.next = minNode.next
        if tail == minNode:
            tail = tail.prev


print(solve(rest_people, k, tail))
