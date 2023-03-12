class ListNode:
    def __init__(self, index, next):
        self.index = index
        self.next = next


def buildRing(n):
    dummy = ListNode(-1, None)
    now = dummy
    for i in range(1, n + 1):
        now.next = ListNode(i, dummy.next)
        now = now.next
    return dummy.next


def who_is_going_home_early(n, k):
    answer = []
    round = n // 2
    ring = buildRing(n)
    dummy = ListNode(-1, ring)
    now = dummy

    while round:
        round -= 1
        for _ in range(k):
            now = now.next
        answer.append(now.next.index)
        now.next = now.next.next

    return answer
