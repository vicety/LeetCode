class Solution:
    def flatten(self, root) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.flatten_inner(root)

    def flatten_inner(self, root):
        if not root:
            return None

        root_right = root.right
        tail = self.flatten_inner(root.left)
        if tail is not None:
            root.right = root.left
            root.left = None
            tail.right = root_right

        if root_right is not None:  # 如果右边还有
            return self.flatten_inner(root_right)
        elif tail is not None:  # 右边没有，左边拼上
            return tail
        else:
            return root  # 两边都没有
