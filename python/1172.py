from collections import OrderedDict

class DinnerPlates:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.nonFull = Deque()  # [0, cap-1]
        self.nonEmpty = Deque()  # [1, cap]
        self.stacks = []

    def push(self, val: int) -> None:
        pushedIndex = -1
        # 无任何元素或全满，需要开新空间
        if not self.nonFull:
            # 没有任何元素
            if not self.nonEmpty:
                pushedIndex = 0
                if len(self.stacks) == 0:
                    self.stacks.append([])
                self.stacks[pushedIndex].append(val)
            else:
                pushedIndex = self.nonEmpty.last() + 1
                if len(self.stacks) < (pushedIndex + 1):
                    self.stacks.append([])
                self.stacks[pushedIndex].append(val)
        # 有最左未满，使用它
        else:
            pushedIndex = self.nonFull.first()

        # 使用新index
        if not self.nonEmpty:
            self.nonEmpty.appendleft(pushedIndex, pushedIndex)  # 恰好val就是index

        # 使用新index且不满
        if not self.nonFull and len(self.stacks[pushedIndex]) < self.cap:
            self.nonFull.append(pushedIndex, pushedIndex)
        if len(self.stacks[pushedIndex]) == self.cap:
            self.nonFull.popleft()

    def pop(self) -> int:
        if not self.nonEmpty:
            return -1
        # 否则使用最右非空
        popedIndex = self.nonEmpty.last()
        ret = self.stacks[popedIndex].pop()

        if len(self.stacks[popedIndex]) == self.cap - 1:
            self.nonFull.append(popedIndex, popedIndex) # 实际上可能造成尾巴多个0,0,0
        if not self.stacks[popedIndex]:
            self.nonEmpty.pop()

        return ret

    def popAtStack(self, index: int) -> int:
        if index > len(self.stacks) - 1 or not self.stacks[index]:
            return -1

        # 必定存在于nonEmpty
        node = self.nonEmpty.getNodeByIndex(index)

        # 有可能新增nonFull节点，get first index < index，append


class Deque:

    def __init__(self):
        self.head = self.Node(-1)  # dumb
        self.tail = self.Node(-1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.indexToNode = OrderedDict()
        self.nodeToIndex = OrderedDict()
        self.nodeToIndex.
        self.len = 0

    def __len__(self):
        return self.len

    def getNodeByIndex(self, index):
        node = self.indexToNode.get(index)
        if node is None:
            return None
        else:
            return node

    def first(self):
        return self.head.val

    def last(self):
        return self.tail.val

    def append(self, index, val):
        node = self.Node(val)
        self.indexToNode[index] = node
        self.nodeToIndex[node] = index
        prevNode = self.tail.prev
        nextNode = self.tail
        nextNode.prev = node
        prevNode.next = node
        node.prev = prevNode
        node.next = nextNode
        self.len += 1

    def appendleft(self, index, val):
        node = self.Node(val)
        self.indexToNode[index] = node
        self.nodeToIndex[node] = index
        prevNode = self.head
        nextNode = self.head.next
        nextNode.prev = node
        prevNode.next = node
        node.prev = prevNode
        node.next = nextNode
        self.len += 1

    def pop(self):
        nodeToDel = self.tail.prev
        index = self.nodeToIndex[nodeToDel]
        prevNode = self.tail.prev.prev
        prevNode.next = self.tail
        self.tail.prev = prevNode
        self.len -= 1
        del self.indexToNode[index]
        del self.nodeToIndex[nodeToDel]
        return nodeToDel.val

    def popleft(self):
        nodeToDel = self.head.next
        index = self.nodeToIndex[nodeToDel]
        prevNode = self.head
        nextNode = self.head.next.next
        prevNode.next = nextNode
        nextNode.prev = prevNode
        self.len -= 1
        del self.indexToNode[index]
        del self.nodeToIndex[nodeToDel]
        return nodeToDel.val

    class Node:
        def __init__(self, val):
            self.val = val
            self.prev = None
            self.next = None
