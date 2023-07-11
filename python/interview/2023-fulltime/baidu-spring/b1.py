# 链表排序
class ListNode:
    def __init__(self, val, next):
        self.val = val
        self.next: ListNode = next


def merge(l1: ListNode, l2: ListNode):
    dummy = ListNode(-1, None)
    now = dummy
    ptr1 = l1
    ptr2 = l2

    while ptr1 and ptr2:
        if ptr1.val <= ptr2.val:
            now.next = ListNode(ptr1.val, None)
            ptr1 = ptr1.next
        else:
            now.next = ListNode(ptr2.val, None)
            ptr2 = ptr2.next
        now = now.next
    while ptr1:
        now.next = ListNode(ptr1.val, None)
        ptr1 = ptr1.next
        now = now.next
    while ptr2:
        now.next = ListNode(ptr2.val, None)
        ptr2 = ptr2.next
        now = now.next

    return dummy.next


def sort(head: ListNode):
    if head is None or head.next is None:
        return head

    slow = head
    fast = head
    # .  .
    # sf
    # .  .  .
    # h  s     f
    while fast.next is not None and fast.next.next is not None:
        fast = fast.next.next
        slow = slow.next

    leftHead = head
    rightHead = slow.next
    slow.next = None

    leftHead = sort(leftHead)
    rightHead = sort(rightHead)

    return merge(leftHead, rightHead)


def buildList(arr):
    dummy = ListNode(-1, None)
    now = dummy
    for item in arr:
        now.next = ListNode(item, None)
        now = now.next
    return dummy.next


def printList(head: ListNode):
    ans = []
    while head is not None:
        ans.append(head.val)
        head = head.next
    return ans


li = buildList([1, 3, 5, 7, 2, 4, 6, 8])
srtdLi = sort(li)
print(printList(srtdLi))
