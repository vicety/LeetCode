import sys


# print('Hello,World!');

# [1, 2, 3, 6, 5, 4]
# [1, 2, 3, 4, 5] -> [1, 2, 3, 5, 4] -> [1, 5, 2, 4, 3]

# [1, 2]

class ListNode:
    def __init__(self, val):
        self.next = None
        self.val = val


def solve(li: ListNode):
    liLen = 0
    now = li
    while now:
        now = now.next
        liLen += 1

    # rev from (n + 1) // 2
    rev = (liLen + 1) // 2
    cnt = rev - 1
    now = li
    while cnt:
        cnt -= 1
        now = now.next
    # now at prev
    prev = now
    nxtHead = now.next

    before = nxtHead
    now = before.next
    nxt = now.next
    while now:
        now.next = before
        before = now
        now = nxt
        if nxt is not None:
            nxt = nxt.next

    prev.next = before
    nxtHead.next = None

    # [1 2 3 5 4] li -> 1 before -> 5
    p1 = li
    p2 = before
    cnt = liLen - 1
    now = True  # True: p1 connect p2, else p2 to p1
    while cnt:
        cnt -= 1
        if now:
            tmp = p1.next
            p1.next = p2
            p1 = tmp
        else:
            tmp = p2.next
            p2.next = p1
            p2 = tmp

        now = not now

    return li


def buildList(li):
    now = ListNode(-1)
    head = now
    for item in li:
        now.next = ListNode(item)
        now = now.next
    return head.next


def printList(li):
    ans = ""
    while li:
        ans += str(li.val) + " "
        li = li.next
    print(ans)


li = buildList([1, 2, 3, 4, 5, 6])
printList(li)
solve(li)
printList(li)