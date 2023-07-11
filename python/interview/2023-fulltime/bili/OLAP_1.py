from python.util.TreeNode import TreeNode


def solve(root: TreeNode):
    ans = []
    maxDepth = 4  # 写死

    def toStr(rt: TreeNode):
        if rt is None:
            return "none"
        return str(rt.val)

    def fullLen(now: TreeNode):
        if now is None:
            # |none or none|
            return 6
        #      |fa
        # |left   right|
        return len(toStr(now.left)) + len(toStr(now.right)) + len(toStr(now)) + 3

    def fill(nowLayer: int, now: TreeNode, leftSon: bool, rightSon: bool):
        if nowLayer == maxDepth:
            return
        if nowLayer == len(ans):
            ans.append("")
        if now is None:
            ans[nowLayer] += " " * 5 + ("" if not leftSon else "|") + "none" + ("" if not rightSon else "|") + " " * 5
            fill(nowLayer + 1, None, True, False)
            fill(nowLayer + 1, None, False, True)
            return

        if leftSon:
            ans[nowLayer] += fullLen(now.left) * " " + "|" + str(now.val) + fullLen(now.right) * " "
        elif rightSon:
            ans[nowLayer] += fullLen(now.left) * " " + str(now.val) + "|" + fullLen(now.right) * " "
        else:
            ans[nowLayer] += fullLen(now.left) * " " + "|" + str(now.val) + "|" + fullLen(now.right) * " "

        fill(nowLayer + 1, now.left, True, False)
        fill(nowLayer + 1, now.right, False, True)

    fill(0, root, False, False)
    return ans


rt = TreeNode(1234)
rt.left = TreeNode(22)
rt.right = TreeNode(33)
rt.left.right = TreeNode(55)
rt.right.left = TreeNode(66)

ans = solve(rt)
for line in ans:
    print(line)
