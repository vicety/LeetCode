from queue import PriorityQueue
from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        q = PriorityQueue()
        ans = [0] * len(temperatures)
        for i, t in enumerate(temperatures):
            while not q.empty() and q.queue[0] < (t, i):
                prev_t, prev_i = q.get()
                ans[prev_i] = i - prev_i
            q.put((t, i))
        return ans
