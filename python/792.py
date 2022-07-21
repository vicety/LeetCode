from typing import List


class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        di = dict()
        for i in range(0, 256):
            di[chr(i)] = set()

        weight = dict()

        for word in words:
            di[word[0]].add((word, word))
            if weight.get(word) is None:
                weight[word] = 0
            weight[word] += 1

        ans = 0
        for c in s:
            mov = di[c]
            tmp = []
            for w, wd in mov:
                if len(w) == 1:
                    ans += weight[wd]
                else:
                    tmp.append((w[1:], wd))
            di[c] = set()

            for t, wd in tmp:
                di[t[0]].add((t, wd))
        return ans
