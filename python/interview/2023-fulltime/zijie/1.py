# encoding: utf-8
# a = input("please input a number:")
# print("hello world")
class ListNode:
    def __init__(self, key, val):
        self.prev = None
        self.next = None
        self.val = val
        self.key = key


class LRUCache:
    def __init__(self, cap):
        self.cap = cap
        self.di = dict()
        self.head = ListNode(-1, -1)
        self.tail = ListNode(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key):
        if not self.di.get(key):
            return -1
        node = self.di[key]
        self.deleteNode(node)
        self.insertNodeToHead(node)
        return node.val

    def put(self, key, val):
        node = self.di.get(key)
        if node:
            self.deleteNode(node)
            node.val = val
        else:
            # new node
            if len(self.di) == self.cap:
                self.deleteNode(self.tail.prev)
            node = ListNode(key, val)
        self.insertNodeToHead(node)

    def deleteNode(self, node):
        key = node.key
        del (self.di[key])
        next_node = node.next
        prev_node = node.prev
        prev_node.next = next_node
        next_node.prev = prev_node

    def insertNodeToHead(self, node):
        self.di[node.key] = node
        # node ptr
        node.next = self.head.next
        node.prev = self.head
        # head and head.next ptr
        self.head.next.prev = node
        self.head.next = node


c = LRUCache(2)
c.put(1, 2)
print(c.get(1))
c.put(2, 3)
print(c.get(1))
c.put(3, 4)
print(c.get(2))

# 大 key / value 是否 在 levelDB 会有问题

# 规模 trace 链路很长，每个模块需要做什么工作
# trace 系统的扩张，怎么展示，分布式，故障

# 热 key，不要用一致性哈希，外部有一个管理 key 的方式
# key Mapping
# 存储系统，没办法
# 比如是 cache，查询系统。
# 搜索，热词
# mapping，不能完全依赖
# 对 key 做哈希，哈希得到环上的编号，具体在那台机器可以动态管理


# class ListNode:
#     def __init__(self, key, val):
#         self.prev = None
#         self.next = None
#         self.key = key
#         self.val = val
#
#
# class LRUCache:
#     def __init__(self, cap):
#         self.cap = cap
#         self.di = dict()
#         self.head = ListNode(-1, -1)
#         self.tail = ListNode(-1, -1)
#         self.head.next = self.tail
#         self.tail.prev = self.head
#
#     def get(self, key):
#         node = self.di.get(key)
#         if node is None:
#             return None
#         self.deleteNode(node)
#         self.insertNodeToHead(node)
#         return node.val
#
#     def put(self, key, value):
#         node = self.di.get(key)
#         if node:
#             self.deleteNode(node)
#             node.val = value
#         else:
#             if len(self.di) == self.cap:
#                 self.deleteNode(self.tail.prev)
#             node = ListNode(key, value)
#         self.insertNodeToHed(node)
#
#     def deleteNode(self, node):
#         del (self.di[node.key])
#         next_node = node.next
#         prev_node = node.prev
#         prev_node.next = next_node
#         next_node.prev = prev_node
#
#     def insertNodeToHead(self, node):
#         self.di[node.key] = node
#         node.prev = self.head
#         node.next = self.head.next
#         self.head.next.prev = node
#         self.head.next = node
