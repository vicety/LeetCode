from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 13245 14325
class Solution:
    def findError(self, root: TreeNode) -> List[int]:
        # write code here
        stack = []
        now = root
        first1, first2 = -1, -1  # 可以用-inf，但是题目里保证了val大于0
        second1, second2 = -1, -1
        prev = float("-inf")
        while now:
            stack.append(now)
            now = now.left
        while len(stack):
            now = stack.pop()

            now_val = now.val
            if now_val < prev:
                if first1 == -1:
                    first1 = prev
                    first2 = now_val
                else:
                    second1 = prev
                    second2 = now_val
                    break
            prev = now_val

            if now.right:
                now = now.right
                while now:
                    stack.append(now)
                    now = now.left

        if second1 == -1:
            return [first2, first1]
        else:
            return [second2, first1]
