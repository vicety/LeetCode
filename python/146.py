class ListNode:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        self.prev = None


class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.di = {}
        self.head = ListNode(None, None)
        self.tail = ListNode(None, None)
        self.head.next = self.tail
        self.tail.prev = self.tail

    def get(self, key: int) -> int:
        if not self.di.get(key):
            return -1
        val = self.di.get(key).val
        self.deleteExistNode(key)
        self.newNodeToHead(key, val)
        return val

    def put(self, key: int, value: int) -> None:
        if not self.di.get(key) and len(self.di) == self.cap:
            self.deleteExistNode(self.tail.prev.key)
        if self.di.get(key) is not None:
            self.deleteExistNode(key)
        self.newNodeToHead(key, value)

    def deleteExistNode(self, key):
        node = self.di[key]
        del (self.di[key])
        next_node = node.next
        prev_node = node.prev
        prev_node.next = next_node
        next_node.prev = prev_node

    def newNodeToHead(self, key, val):
        newNode = ListNode(key, val)
        self.di[key] = newNode
        # nextNode ptr
        newNode.next = self.head.next
        self.head.next.prev = newNode
        # head ptr
        self.head.next = newNode
        newNode.prev = self.head


l = LRUCache(2)
l.put(2, 1)
l.put(3, 2)
print(l.get(2))
l.put(4, 3)
print(l.get(3))
print(l.get(4))
l.put(2, 2)
