# Given
# the
# head
# of
# a
# singly
# linked
# list and two
# integers
# left and right
# where
# left <= right, reverse
# the
# nodes
# of
# the
# list
# from position left
#
# to
# position
# right, and return the
# reversed
# list.
#
# Example
# 1:
#
# Input: head = [1, 2, 3, 4, 5], left = 2, right = 4
# Output: [1, 4, 3, 2, 5]
# Example
# 2:
#
# Input: head = [5], left = 1, right = 1
# Output: [5]
#
# Constraints:
#
# The
# number
# of
# nodes in the
# list is n.
# 1 <= n <= 500
# -500 <= Node.val <= 500
# 1 <= left <= right <= n
# 钱文亿
# # Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class DummyTail(ListNode):
    def __init__(self):
        super().__init__()
        self.prev = None


def solve(head: ListNode, left, right):
    dummy = ListNode()
    dummy.next = head
    now = head
    sz = 1
    while now.next:
        sz += 1
        now = now.next
    now.next = DummyTail()
    dummyTail = now.next
    now.next.prev = now

    # before: --- prevPrev | _tail --- _head | nxtNxt
    # after: --- prevPrev | _head --- _tail | nxtNxt

    prevPrev = dummy
    _left = left - 1
    while _left > 0:
        prevPrev = prevPrev.next
        _left -= 1
    _tail = prevPrev.next

    _head = _tail
    for _ in range(right - left):
        _head = _head.next

    nxtNxt = _head.next

    # print(prevPrev.val, _head.val, _tail.val, nxtNxt.val)

    # reverse from _tail to _head
    prev = _tail
    now = prev.next
    for _ in range(right - left):
        nxt = now.next
        now.next = prev
        # print(now.val, prev.val)

        prev = now
        now = nxt

    # connect prevPrev to _head, _tail to nxtNxt, cancel dummyTail
    prevPrev.next = _head
    _tail.next = nxtNxt
    if right != sz:
        dummyTail.prev.next = None
    else:
        _tail.next = None

    # 1 2 3

    return dummy.next


def buildList(arr):
    dummy = ListNode()
    now = dummy
    for num in arr:
        now.next = ListNode(num)
        now = now.next
    return dummy.next


def printList(head):
    ans = ""
    now = head
    while head:
        ans += str(head.val) + " "
        head = head.next
    return ans


lst = buildList([1, 2, 3, 4, 5])
print(printList(solve(lst, 2, 4)))

lst = buildList([5])
print(printList(solve(lst, 1, 1)))

lst = buildList([1, 2, 3, 4, 5])
print(printList(solve(lst, 1, 5)))
