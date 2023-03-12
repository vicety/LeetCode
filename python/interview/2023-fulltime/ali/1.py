class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


def buildList(n):
    dummy = Node(-1)
    now = dummy
    i = 1
    while n:
        now.next = Node(i)
        now = now.next
        n -= 1
        i += 1
    now.next = dummy.next
    return dummy.next


n = 10
m = 3
li = buildList(n)
dummy = Node(-1)
dummy.next = li
now = dummy
while True:
    for _ in range(m - 1):  # TODO: m == 1
        now = now.next
    # delete now.next
    print(now.next.val)
    if now.next == now:
        break
    now.next = now.next.next

# 1 2 3 4 5 6 7 8 9 10
#     3     6     9