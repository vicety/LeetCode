from typing import List
from queue import PriorityQueue


class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.q = PriorityQueue()
        self.k = k
        for num in nums:
            self.add(num)

    def add(self, val: int) -> int:
        if len(self.q.queue) < self.k:
            self.q.put(val)
            return self.q.queue[0]
        if val < self.q.queue[0]:
            return self.q.queue[0]
        else:
            self.q.get()
            self.q.put(val)
            return self.q.queue[0]
