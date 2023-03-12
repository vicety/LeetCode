from util.ListNode import ListNode


def buildList(arr):
    dummy = ListNode(-1)
    now = dummy
    for item in arr:
        now.next = ListNode(item)
        now = now.next
    return dummy.next

def printList(li: ListNode):
    if not li:
        return
    print(li.val)
    printList(li.next)

class Solution:
    def xorList(self, a: ListNode, b: ListNode) -> ListNode:
        # write code here
        def rev(a: ListNode):
            now = a
            nxt = a.next
            now.next = None
            while nxt:
                nxtNxt = nxt.next
                nxt.next = now
                now = nxt
                nxt = nxtNxt
            return now

        a = rev(a)

        # printList(a)
        # printList(b)

        resDummy = ListNode(-1)
        now = resDummy
        aNow = a
        bNow = b
        while aNow and bNow:
            now.next = ListNode(aNow.val ^ bNow.val)
            now = now.next
            aNow = aNow.next
            bNow = bNow.next
        while aNow:
            now.next = ListNode(aNow.val)
            now = now.next
            aNow = aNow.next
        while bNow:
            now.next = ListNode(bNow.val)
            now = now.next
            bNow = bNow.next

        ans = rev(resDummy.next)
        while ans is not None and ans.val == 0:
            ans = ans.next
        if ans is None:
            return ListNode(0)
        return ans



