from typing import Optional


class Solution:
    def deleteNode(self, root, key: int):
        if root is None:
            return None
        if key < root.val:
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            if root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            else:
                leftMaxNode = root.left
                while leftMaxNode.right is not None:
                    leftMaxNode = leftMaxNode.right
                root.val = leftMaxNode.val
                root.left = self.deleteNode(root.left, root.val)
        return root
