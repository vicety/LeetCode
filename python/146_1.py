class ListNode:
    def __init__(self):
        self.prev = None
        self.nxt = None
        self.key = None
        self.val = None


class LRUCache_1:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.head = ListNode()
        self.tail = ListNode()
        self.head.nxt = self.tail
        self.tail.prev = self.head
        self.di = dict()  # key to node

    def get(self, key: int) -> int:
        if key not in self.di:
            return -1

        val = self.di[key].val
        self.deleteNode(key)
        self.insertHead(key, val)
        return val

    def put(self, key: int, value: int) -> None:
        # if exist, delete
        if key in self.di:
            self.deleteNode(key)
        # print(key, value)
        self.insertHead(key, value)

        # evict if more than cap
        if len(self.di) > self.cap:
            self.deleteNode(self.tail.prev.key)

    # assume node does not exist
    def insertHead(self, key: int, value: int):
        node = ListNode()
        self.di[key] = node

        node.key = key
        node.val = value
        nxt = self.head.nxt

        self.head.nxt = node
        nxt.prev = node
        node.nxt = nxt
        node.prev = self.head

    def deleteNode(self, key: int):
        node = self.di[key]
        del self.di[key]

        node.prev.nxt = node.nxt
        node.nxt.prev = node.prev

    # def printList(self):
    #     ans = ""
    #     now = self.head
    #     while now:
    #         ans += "({} {})".format(now.key, now.val)
    #         now = now.nxt
    #     print(ans)

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)