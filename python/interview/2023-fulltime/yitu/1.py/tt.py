#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
#
# @param input int整型一维数组
# @param k int整型
# @return int整型一维数组
#

# default small heap
from typing import List


# leetcode 912 模板排序能过 11/18 TLE 正确性应该是 ok 的
class Heap:
    def __init__(self) -> None:
        self.arr = [None]  # dummy

    def len(self):
        return len(self.arr) - 1

    # up
    def put(self, v):
        self.arr.append(v)
        idx = len(self.arr) - 1
        self.up(idx)

    def peek(self):
        if len(self.arr) < 1:
            return None
        return self.arr[1]

    # swap + down
    def get(self):
        ret = self.peek()
        self.arr[1] = self.arr[len(self.arr) - 1]
        self.arr = self.arr[:-1]
        # NOTE：如果已经没有元素，那么 get 后不需要 down
        if self.len() > 1:
            self.down(1)
        return ret

    def up(self, idx):
        faIdx = idx // 2
        # NOTE：边界条件，只有一个节点的情况
        # NOTE：注意一定是 idx == 1
        # TODO：是否改成 idx == 1 就足够了？
        if idx == 1:
            return
        elif self.arr[faIdx] > self.arr[idx]:
            self.arr[faIdx], self.arr[idx] = self.arr[idx], self.arr[faIdx]
            self.up(faIdx)

    def down(self, idx):
        lCh = idx * 2
        rCh = idx * 2 + 1

        cmp = [(self.arr[idx], idx)]
        if lCh < len(self.arr):
            cmp.append((self.arr[lCh], lCh))
        if rCh < len(self.arr):
            cmp.append((self.arr[rCh], rCh))
        cmp = sorted(cmp)
        if cmp[0][0] != self.arr[idx]:
            swpIdx = cmp[0][1]
            self.arr[idx], self.arr[swpIdx] = self.arr[swpIdx], self.arr[idx]
            self.down(swpIdx)


class Solution:
    def GetLeastNumbers_Solution(self, input: List[int], k: int) -> List[int]:
        # write code here
        if k == 0:
            return []

        hp = Heap()
        for inp in input:
            if hp.len() < k:
                hp.put(-inp)
            elif -inp > hp.peek():
                hp.get()
                hp.put(-inp)

        ans = []
        while hp.len() > 0:
            ans.append(hp.get())
        return sorted(list(map(lambda x: -x, ans)))
