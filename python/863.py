class Solution:
    def distanceK(self, root, target, k: int):
        if root is None:
            return None
        return self.solve(root, [], target, k)

    def solve(self, root, stack, target, k):
        if root is None:
            return []

        stack.append(root)
        # print(list(map(lambda x: x.val, stack)))
        if root.val == target.val:
            # since all values are unique, no need to distinguish left or right
            n = k
            ans = []
            fr = None
            s = []
            for i in stack:
                s.append(i)
            while n >= 0 and len(s):
                node = s.pop()
                ans += self.searchN(node, n, k, fr)
                fr = node.val
                n -= 1
            return ans
        else:
            ans = self.solve(root.left, stack, target, k)
            if ans:
                return ans
            ans = self.solve(root.right, stack, target, k)
            if ans:
                return ans
        stack.pop()
        return []  # not found

    def searchN(self, root, n, k, stop_val):
        if not root:
            return []
        if root.val == stop_val:
            return []
        if n == 0:
            return [root.val]
        return self.searchN(root.left, n - 1, k, stop_val) + self.searchN(root.right, n - 1, k, stop_val)
