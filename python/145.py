# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# 2:38
from typing import List, Optional

from util.TreeNode import TreeNode


class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        dataStack = []
        now = root
        while now:
            dataStack.append((now, False))
            now = now.left
        ans = []
        while dataStack:
            item, vis = dataStack.pop()
            if not vis:
                dataStack.append((item, True))
                now = item.right
                while now:
                    dataStack.append((now, False))
                    now = now.left
            else:
                ans.append(item.val)
        return ans
# 2:43 fin
