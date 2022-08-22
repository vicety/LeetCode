from typing import List


class Solution:
    def verifyPostorder(self, postorder: List[int]) -> bool:
        return self.solve(postorder, 0, len(postorder) - 1)

    def solve(self, arr, l, r):
        if l > r:
            return True
        root = arr[r]
        div = r  # left end (open)
        for i in range(l, r):
            if arr[i] > root:
                div = i
                break

        for i in range(l, div):
            if arr[i] > root:
                return False

        for i in range(div, r):
            if arr[i] < root:
                return False

        return self.solve(arr, l, div - 1) and self.solve(arr, div, r - 1)
