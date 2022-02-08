from typing import List


class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        # 只有乘除有必要单独算 (5 * 10 - 2) / 2

        # 覆盖2个的所有情况，传递下标
        def solve2(a, b, target):
            a = cards[a]
            b = cards[b]
            return a - b == target or b - a == target or a * b == target or a == b * target or b == a * target

        # 覆盖3个的所有情况，传递下标 三个一定能拆成 1 + 2
        def solve3(a, b, c, target):
            combs = [(a, b, c), (a, c, b), (b, a, c), (b, c, a), (c, a, b), (c, b, a)]
            for i, j, k in combs:
                if solve2(j, k, target + cards[i]) or solve2(j, k, target - cards[i]) or solve2(j, k,
                                                                                                target * cards[i]):
                    return True
                if target % cards[i] == 0 and solve2(j, k, target / cards[i]):
                    return True
            return False

        comb2 = [(0, 1, 2, 3), (0, 2, 1, 3), (0, 3, 1, 2)]
        combResults = [(2, 48), (1, 24), (2, 12), (4, 6)]


        for comb in comb2:
            for combResult in combResults:
                if solve2(comb[0], comb[1], combResult[0]) and solve2(comb[2], comb[3], combResult[1]):
                    return True
                if solve2(comb[2], comb[3], combResult[1]) and solve2(comb[0], comb[1], combResult[0]):
                    return True

        # 中间是乘除，或者说括号加在左右半边
        combs = [0, 1, 2, 3]
        for comb in combs:
            num = combs[comb]
            cds = combs[:comb] + combs[comb + 1:]
            if solve3(cds[0], cds[1], cds[2], 24 - cards[num]) or solve3(cds[0], cds[1], cds[2], 24 + cards[num]) \
                    or solve3(cds[0], cds[1], cds[2], 24 * cards[num]):
                return True
            if 24 % cards[num] == 0 and solve3(cds[0], cds[1], cds[2], 24 / cards[num]):
                return True
        return False


s = Solution()
print(s.judgePoint24([1, 3, 1, 3]))
print(s.judgePoint24([1, 2, 1, 2]))
print(s.judgePoint24([9, 5, 1, 2]))
print(s.judgePoint24([4, 1, 8, 7]))
