class Solution:
    def maxDepth(self, root) -> int:
        if not root:
            return 0
        l_depth = self.maxDepth(root.left) + 1
        r_depth = self.maxDepth(root.right) + 1
        return max(l_depth, r_depth)
