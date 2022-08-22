# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def kthLargest(self, root: TreeNode, k: int) -> int:
        stack = []
        now = root
        while now:
            stack.append(now)
            now = now.right

        n = 0
        while stack:
            n += 1
            node = stack.pop()
            if n == k:
                return node.val
            if node.left:
                now = node.left
                while now:
                    stack.append(now)
                    now = now.right
