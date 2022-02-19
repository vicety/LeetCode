class Solution:
    def maxPathSum(self, root) -> int:
        return max(self.solve(root))

    def solve(self, root):
        if not root:
            return -100000, -100000
        left, left_final = self.solve(root.left)
        right, right_final = self.solve(root.right)
        return max(root.val, left + root.val, right + root.val), max(left, right, left_final, right_final,
                                                                     left + root.val + right)
