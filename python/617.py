class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def mergeTrees(self, root1, root2):
        if root1 is None and root2 is None:
            return None
        if root2 is None:
            return root1
        elif root1 is None:
            return root2
        return TreeNode(root1.val + root2.val,
                        self.mergeTrees(root1.left, root2.left),
                        self.mergeTrees(root1.right, root2.right))
