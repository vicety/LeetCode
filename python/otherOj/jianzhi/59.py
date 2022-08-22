from collections import deque
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not nums:
            return []

        stack = deque()  # (val, pos)
        ans = []
        for i in range(k - 1):
            self.forward(stack, i, nums[i], k)
        for i in range(k - 1, len(nums)):
            self.forward(stack, i, nums[i], k)
            ans.append(self.query(stack))

        return ans

    def forward(self, stack, i, val, k):
        if stack and i - stack[0][1] == k:
            stack.popleft()
        while stack and stack[-1][0] <= val:
            stack.pop()
        stack.append((val, i))
        print(stack)

    def query(self, stack):
        return stack[0][0]
