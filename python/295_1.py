from queue import PriorityQueue


class MedianFinder:

    def __init__(self):
        self.lower = PriorityQueue()
        self.higher = PriorityQueue()

    def addNum(self, num: int) -> None:
        # 这一步可能导致 高半部 的数被添加到 低半部集合
        self.lower.put(-num)
        # print(self.lower.queue, self.higher.queue)
        # 先平衡数量
        if len(self.lower.queue) > len(self.higher.queue):
            self.higher.put(-self.lower.get())
        # 如果不需要平衡，第一行注释的问题可能仍然没有被解决
        # 但此时确保数量是平衡的，且两个队列均不为空
        elif -self.lower.queue[0] > self.higher.queue[0]:
            self.higher.put(-self.lower.get())
            self.lower.put(-self.higher.get())
        # print(self.lower.queue, self.higher.queue)

    def findMedian(self) -> float:
        if len(self.higher.queue) == len(self.lower.queue):
            return (-self.lower.queue[0] + self.higher.queue[0]) / 2
        return self.higher.queue[0]

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()

# [] [1]
# [2] [1]
# [2] [1 3]