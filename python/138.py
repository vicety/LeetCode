class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        cp = Node(0)
        original = head
        mp = {}

        cpNow = cp
        while original is not None:
            cpNow.next = Node(original.val)
            cpNow = cpNow.next
            mp[original] = cpNow
            original = original.next

        cpNow = cp.next
        original = head
        while original is not None:
            if original.random is not None:
                cpNow.random = mp[original.random]
            original = original.next
            cpNow = cpNow.next

        return cp.next
