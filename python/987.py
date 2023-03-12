# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import PriorityQueue
from typing import List, Optional

from util.TreeNode import TreeNode


class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        stat = [None] * 2010

        def dfs(now, nowx, nowy):
            if not now:
                return
            if not stat[nowx]:
                stat[nowx] = PriorityQueue()
            stat[nowx].put((nowy, now.val))
            dfs(now.left, nowx - 1, nowy + 1)
            dfs(now.right, nowx + 1, nowy + 1)

        dfs(root, 0, 0)

        ans = []
        for i in range(-1000, 1000):
            if stat[i]:
                tmp = []
                while stat[i].qsize():
                    tmp.append(stat[i].get()[1])
                ans.append(tmp)
        return ans
