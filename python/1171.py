# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional

from util.ListNode import ListNode


class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        di = dict()  # preSum -> prev_node
        cur_sum = 0
        dummy = ListNode(-1, head)
        now = head
        di[0] = dummy
        stack = [(dummy, 0)]

        while now:
            cur_sum += now.val
            if cur_sum in di:
                prev = di[cur_sum]
                prev.next = now.next
                while stack[-1][0] != prev:
                    _, prev_sum = stack[-1]
                    del di[prev_sum]
                    stack.pop()
            else:
                di[cur_sum] = now
                stack.append((now, cur_sum))
            now = now.next
        return dummy.next


# testLi = ListNode.fromList([1, 3, 2, -3, -2, 5, 5, -5, 1])
# testLi = ListNode.fromList([0, 0])
s = Solution()
print(ListNode.toString(s.removeZeroSumSublists(testLi)))
