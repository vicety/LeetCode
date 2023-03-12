# reverse signly linked list in recursive way
# 1 -> 2 -> 3 -> 4 -> 5
# 5 -> 4 -> 3 -> 2 -> 1

class ListNode:
    def __init__(self):
        self.val = None
        self.next = None


def reverse(head: ListNode):
    if head is None or head.next is None:
        return head
    ret = reverse(head.next)
    head.next.next = head
    head.next = None
    return ret


def makeList(arr):
    dummy = ListNode()
    now = dummy
    for num in arr:
        now.next = ListNode()
        now.next.val = num
        now = now.next
    return dummy.next


def printList(head):
    s = ""
    while head:
        s += str(head.val) + " "
        head = head.next
    print(s)


lst = makeList([1, 2, 3, 4, 5])
# lst = makeList([])
printList(reverse(lst))


# Given the root of a binary tree, flatten the tree into a "linked list":

# The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
# The "linked list" should be in the same order as a pre-order traversal of the binary tree.


#     1
#  2.    3
# 4.  5.     6

# 1
#  2
# 4 5
#    3
#     6


# . 1
#  2
#    4
#      5
#        3
#  6

def solve(root):
    if not root:
        return None, None
    flattenLHead, flattenLTail = solve(root.left)
    flattenRHead, flattenRTail = solve(root.right)
    if flattenLTail is not None:
        root.right = flattenLHead
        flattenLTail.right = flattenRHead
        if flattenRTail:
            return root, flattenRTail
        else:
            return root, flattenLTail
    else:
        root.right = flattenRHead
        if flattenRTail:
            return root, flattenRTail
        else:
            return root, root

    # if root.left is not None:
    #     now = root.left
    #     while now.right is not None:
    #         now = now.right
    #     now.right = root.right
    #     root.right = root.left
    #     root.left = None
    # solve(root.right)


class TreeNode:
    def __init__(self, val):
        self.left = None
        self.right = None
        self.val = val


nodes = [TreeNode(i) for i in range(0, 7)]
nodes[1].left = nodes[2]
nodes[1].right = nodes[3]
nodes[2].left = nodes[4]
nodes[2].right = nodes[5]
nodes[3].right = nodes[6]

solve(nodes[1])
now = nodes[1]
s = ""
while now:
    s += str(now.val) + " "
    now = now.right
print(s)

# def say_hello():
#     print('Hello, World')

# for i in range(5):
#     say_hello()
