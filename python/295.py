from queue import PriorityQueue


class MedianFinder:

    def __init__(self):
        self.minQ = PriorityQueue()
        self.maxQ = PriorityQueue()

    def addNum(self, num: int) -> None:
        self.minQ.put(num)
        while len(self.minQ.queue) > len(self.maxQ.queue) + 1:
            self.maxQ.put(-self.minQ.get())

    def findMedian(self) -> float:
        if len(self.minQ.queue) != len(self.maxQ.queue):
            return self.minQ.queue[0]
        return (self.minQ.queue[0] - self.maxQ.queue[0]) / 2

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
