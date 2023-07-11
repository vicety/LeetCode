from typing import List


class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        # try all values (deletion num) until impossible, 0 is already an answer
        # for each deletion num, find the min value geq than previous

        def findMinGeqThanPrev(prev: List[int], s: str):
            lastIdx = -1
            ans = ""
            alreadyGreater = False
            for i in range(len(prev)):
                # "abcd"
                # valid range [lastIdx + 1, len(s) - len(prev)]
                minVal = 256
                minIdx = -1
                for j in range(lastIdx + 1, len(s) - len(prev) + 1 + i):
                    cord = ord(s[j])
                    if minVal > cord and (alreadyGreater or cord >= prev[i]):
                        minVal = cord
                        minIdx = j
                        if cord > prev[i]:
                            alreadyGreater = True

                if minIdx == -1:
                    return None

                ans += s[minIdx]
                lastIdx = minIdx
            return ans

        keep = 0
        for i in range(1, len(strs[0]) + 1):
            # i -> keep i chars
            cnt = 0
            last = [0] * i
            for s in strs:
                newLast = findMinGeqThanPrev(last, s)
                if newLast is None:
                    return len(strs[0]) - keep
                print(s, newLast)
                last = list(map(lambda x: ord(x), newLast))
                cnt += 1
            if cnt == len(strs):
                keep = i

        return len(strs[0]) - keep


s = Solution()
# print(s.minDeletionSize(["ca","bb","ac"]))
# print(s.minDeletionSize(["xc", "yb", "za"]))
# print(s.minDeletionSize(["zyx", "wvu", "tsr"]))
print(s.minDeletionSize(["jwkwdc", "etukoz"]))
