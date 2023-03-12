# lc 8
class Solution:
    def myAtoi(self, s: str) -> int:
        def handleRet(now, pm):
            now = now * (-1 if pm == '-' else 1)
            if now < -2 ** 31:
                now = -2 ** 31
            if now > 2 ** 31 - 1:
                now = 2 ** 31 - 1
            return now

        # write code here
        s = s.strip()
        pm = None
        metNum = False
        now = 0
        for c in s:
            if c == '+' or c == '-':
                # NOTE：之前漏了 metNum
                # 导致这个 case 没过 "00000-42a1234"
                if pm is None and not metNum:
                    pm = c
                else:
                    return handleRet(now, pm)
            elif ord("0") <= ord(c) <= ord("9"):
                metNum = True
                now = now * 10 + ord(c) - ord('0')
            else:
                # if now > 0 or pm is not None:
                return handleRet(now, pm)
        return handleRet(now, pm)