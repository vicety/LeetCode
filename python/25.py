from typing import Optional

from python.util.ListNode import ListNode


class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        # n >= k
        # beforeLast | nextFirst -> nextLast | nextNextFirst
        dummy = ListNode(-1, head)

        # return nextLst
        def nextK(now: ListNode, k):
            while k:
                k -= 1
                if not now.next:
                    return None
                now = now.next
            return now

        beforeLast = dummy
        while True:
            nextLast = nextK(beforeLast, k)
            if not nextLast:
                break
            nextFirst = beforeLast.next
            nextNextFirst = nextLast.next  # notice, can be null

            # reverse from nextFirst to nextLast
            nextLast.next = None
            prev = None
            now = nextFirst
            next = nextFirst.next
            while True:
                now.next = prev
                if next is None:
                    break  # now is nextLast
                prev = now
                now = next
                next = next.next
            beforeLast.next = now
            nextFirst.next = nextNextFirst
            beforeLast = nextFirst

        return dummy.next


s = Solution()

l = ListNode.fromList([1, 2, 3, 4, 5, 6, 7])
print(ListNode.toString(s.reverseKGroup(l, 1)))

l = ListNode.fromList([1, 2, 3, 4, 5, 6, 7])
print(ListNode.toString(s.reverseKGroup(l, 2)))

l = ListNode.fromList([1, 2, 3, 4, 5, 6, 7])
print(ListNode.toString(s.reverseKGroup(l, 3)))

l = ListNode.fromList([1, 2, 3, 4, 5, 6, 7])
print(ListNode.toString(s.reverseKGroup(l, 4)))
