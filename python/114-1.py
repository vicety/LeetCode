class Solution:
    def flatten(self, root) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.solve(root)

    # return last element
    def solve(self, root):
        if root is None:
            return None

        
