from typing import List
from queue import PriorityQueue


class ListNode:
    def __init__(self, st, ed):
        self.st = st
        self.ed = ed
        self.next = None
        self.prev = None

    def __eq__(self, other):
        return True

# 想法是总是合并当前代价最小的，但是好像不对

class Solution:
    def minCost(self, n: int, cuts: List[int]) -> int:
        id = 0

        def getId():
            nonlocal id
            id += 1
            return id

        pq = PriorityQueue()
        cancel = set()
        optionToId = dict()
        lst = ListNode(None, None)  # dummy head
        cuts = sorted(cuts)
        cuts.append(n)
        now = 0
        nowNode = lst
        for cut in cuts:
            # start[now] = cut
            # end[cut] = now
            nowNode.next = ListNode(now, cut)
            nowNode.next.prev = nowNode
            nowNode = nowNode.next
            if nowNode.prev.st is not None:
                _id = getId()
                optionToId[nowNode.prev.st] = _id
                pq.put((nowNode.ed - nowNode.prev.st, nowNode.prev, _id))  # val, first seg
            now = cut
        # 最后一段没有注册到 optionToId
        optionToId[nowNode.st] = -1
        nowNode.next = ListNode(None, None)  # dummy tail
        ans = 0
        while len(pq.queue):
            val, firstSeg, _id = pq.get()
            if _id in cancel:
                continue
            print(firstSeg.st, firstSeg.ed, firstSeg.next.st, firstSeg.next.ed)
            secSeg = firstSeg.next
            ans += val
            secSeg.next.prev = firstSeg
            firstSeg.next = secSeg.next
            firstSeg.ed = secSeg.ed
            cancel.add(optionToId[secSeg.st])

            if firstSeg.prev.st is not None:
                cancel.add(optionToId[firstSeg.prev.st])
                newId = getId()
                optionToId[firstSeg.prev.st] = newId
                pq.put((firstSeg.ed - firstSeg.prev.st, firstSeg.prev, newId))

            if firstSeg.next.st is not None:
                # no need to add to cancel
                newId = getId()
                optionToId[firstSeg.st] = newId
                pq.put((firstSeg.next.ed - firstSeg.st, firstSeg, newId))
        return ans

        # del start[st]
        # del end[ed]
        # prev = None
        # if end.get(st) is not None:
        #     prev = end[st]
        # nxt = None
        # if start.get(ed) is not None:
        #     nxt = start[ed]
        # if prev is None:
        #     start[st] = nxt
        #     end[nxt] = st
        #     pq.put(nxt - st, )


s = Solution()
# print(s.minCost(7, [1, 3, 4, 5]))
# print(s.minCost(9, [5, 6, 1, 4, 2]))
print(s.minCost(34, [3, 7, 9, 10, 11, 16, 19, 20, 23, 26, 29, 31, 32, 33]))
