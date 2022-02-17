class Solution:
    def decodeAtIndex(self, s: str, k: int) -> str:
        segs = []  # loop str
        base = []
        repeat = []  # extra sequence
        seg = ""
        cur = 0
        for c in s:
            if not self.isNum(c):
                seg += c
                cur += 1
                if k == cur:
                    return c
            else:
                num = ord(c) - ord('0')
                segs.append(seg)
                seg = ""
                base.append(cur)
                cur *= num
                repeat.append(cur)
                if k <= cur:
                    i = len(segs) - 1
                    k -= 1
                    while True:
                        k %= base[i]
                        if i == 0:
                            return segs[0][k]
                        elif k >= repeat[i - 1]:
                            return segs[i][k - repeat[i - 1]]
                        else:
                            i -= 1

    def isNum(self, c):
        return c is not None and ("2" <= c <= "9")


s = Solution()
print(s.decodeAtIndex("leet2code3", 10))
print(s.decodeAtIndex("ha22", 5))
print(s.decodeAtIndex("a2345678999999999999999", 1))
print(s.decodeAtIndex("a2b3c4d5e6f7g8h9", 623529))
print(s.decodeAtIndex("vzpp636m8y", 2920))
#  (2544+1)*8 2920-2544=376 vzpp -> 376

# print()
