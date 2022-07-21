from typing import List
from queue import PriorityQueue
from collections import deque


class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        q = PriorityQueue()
        for i, line in enumerate(mat):
            s = sum(line)
            if len(q.queue) == k:
                if s < -q.queue[0][0]:  # less than max
                    q.get()
                    q.put((-s, -i))
            else:
                q.put((-s, -i))
        ans = []
        while len(q.queue):
            ans.append(-q.get()[1])
        ans = ans[::-1]
        return ans

