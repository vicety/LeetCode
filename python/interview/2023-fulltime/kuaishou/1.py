import sys
from queue import Queue


# print('Hello,World!');

class TreeNode:
    def __init__(self, _val):
        self.val = _val
        self.left = None
        self.right = None


def solve(root: TreeNode):
    ans = []
    q = Queue()
    q.put((root, 0, 1))
    while len(q.queue):
        now, level, idx = q.get()
        if level == len(ans):
            ans.append([])
            for _ in range(2 ** level):
                ans[-1].append("null")
        idxInArr = idx - (int(2 ** (level)))

        if now:
            ans[-1][idxInArr] = now.val
            q.put((now.right, level + 1, idx * 2 + 1))
            q.put((now.left, level + 1, idx * 2))

    ans.pop()
    # popLast = True
    # if len(ans) > 0:
    #     for item in ans[-1]:
    #         if item != "null":
    #             popLast = False
    # if len(ans) > 0 and popLast:
    #     ans.pop()

    return ans


root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)
root.right.left.left = TreeNode(10)

print(solve(root))