# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
#
# @param head ListNode类
# @param k int整型
# @return ListNode类
# {1,2},2
# {1,2,3},2
#
class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        # write code here
        if k == 1:
            return head
        # prevHead prevTail nxtHead nxtTail nxtNxt
        #              -1      |-------|      +1
        dummy = ListNode(-1)
        dummy.next = head
        prevTail = dummy
        while True:
            # find nxtHead, nxtTail
            now = prevTail.next
            nxtHead = now
            for _ in range(k - 1):
                if not now:
                    return dummy.next
                now = now.next
            if not now:
                return dummy.next
            # make sure nxtHead, nxtTail is not None
            nxtTail = now
            nxtNxt = now.next

            # reverse from nxtHead to nxtTail
            prev = nxtHead
            now = nxtHead.next
            for _ in range(k - 1):
                nxt = now.next
                now.next = prev
                prev = now
                now = nxt

            # connect prevTail to nxtTail, nxtHead to nxtNxt
            prevTail.next = nxtTail
            nxtHead.next = nxtNxt

            prevTail = nxtHead