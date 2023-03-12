from typing import List


class Trie:
    def __init__(self):
        self.root = TrieNode(-1)

    def addSeq(self, seq):
        now = self.root
        for num in seq:
            if now.son.get(num) is None:
                now.son[num] = TrieNode(num)
            now = now.son[num]
        now.cnt += 1

    def find(self, seq):
        now = self.root
        for num in seq:
            if now.son.get(num) is None:
                return 0
            now = now.son[num]
        return now.cnt


class TrieNode:
    def __init__(self, val):
        self.val = val
        self.son = dict()
        self.cnt = 0


class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        trie = Trie()
        n = len(grid)
        for i in range(n):
            trie.addSeq(grid[i])
        ans = 0
        for i in range(n):
            column = [grid[j][i] for j in range(n)]
            ans += trie.find(column)
        return ans


s = Solution()
print(s.equalPairs([[3, 2, 1], [1, 7, 6], [2, 7, 7]]))
print(s.equalPairs([[3, 1, 2, 2], [1, 4, 4, 5], [2, 4, 2, 2], [2, 4, 2, 2]]))

# 序列匹配，考虑能否字典树
