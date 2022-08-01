# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    @staticmethod
    def fromList(l: list):
        dummy = ListNode(-1, None)
        now = dummy
        for i in l:
            now.next = ListNode(i, None)
            now = now.next
        return dummy.next

    @staticmethod
    def toString(head):
        s = ""
        while head:
            s += str(head.val) + " "
            head = head.next
        return s
