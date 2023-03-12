import queue

from util.TreeNode import TreeNode


class Solution:
    def cyclicShiftTree(self, root: TreeNode, k: int) -> TreeNode:
        data = []  # level 0-base -> [(node, idx)]
        idxToNode = dict()  # idx -> (node, idx at data[level])

        from queue import Queue
        q = Queue()
        q.put((root, 1, 1))  # node, idx, level
        while len(q.queue):
            node, idx, level = q.get()
            if len(data) < level:
                data.append([])
            data[-1].append((node, idx))
            idxToNode[idx] = (node, len(data[-1]) - 1)
            if node.left:
                q.put((node.left, idx * 2, level + 1))
            if node.right:
                q.put((node.right, idx * 2 + 1, level + 1))

        for i in range(len(data) - 1, 0, -1):
            bind = []
            for node, idx in data[i]:
                fa, arrIdxAtUpLevel = idxToNode[idx // 2]
                delta = (k + (1 if idx % 2 == 1 else 0)) // 2
                nxtFa, nxtFaIdx = data[i - 1][(arrIdxAtUpLevel + delta) % len(data[i - 1])]

                fa.left = None
                fa.right = None
                if (idx + k) % 2 == 0:
                    bind.append((nxtFa, "l", node))
                    # fa.right = node
                else:
                    bind.append((nxtFa, "r", node))
                    # nxtFa.left = node
            for fa, lr, newNode in bind:
                if lr == "l":
                    fa.left = newNode
                else:
                    fa.right = newNode

        # def traverse(now):
        #     if not now:
        #         return
        #     print(now.val)
        #     traverse(now.left)
        #     traverse(now.right)
        #
        # traverse(root)

        return root


s = Solution()
rt = TreeNode(1)
rt.left = TreeNode(2)
rt.right = TreeNode(3)
rt.right.left = TreeNode(4)
rt.right.right = TreeNode(5)
s.cyclicShiftTree(rt, 1)

# rt = TreeNode(1)
# rt.left = TreeNode(2)
# rt.right = TreeNode(3)
# rt.left.left = TreeNode(4)
# s.cyclicShiftTree(rt, 2)
