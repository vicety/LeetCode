class Solution:
    def deleteNode(self, root, key: int):
        if root is None:
            return None
        if key < root.val:
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            if root.left is None and root.right is None:
                return None
            elif root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            else:
                l_node = root.left
                while l_node.right is not None:
                    l_node = l_node.right
                root.val = l_node
                root.left = self.deleteNode(root.left, root.val)
        return root
