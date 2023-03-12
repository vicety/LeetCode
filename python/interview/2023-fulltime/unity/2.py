#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
#
# @param s string字符串
# @return int整型
#
class Solution:
    def StrToInt(self, s: str) -> int:
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
        now = 0
        for c in s:
            if c == '+' or c == '-':
                if pm is None:
                    pm = c
                else:
                    return handleRet(now, pm)
            elif ord("0") <= ord(c) <= ord("9"):
                now = now * 10 + ord(c) - ord('0')
            else:
                # if now > 0 or pm is not None:
                return handleRet(now, pm)
        return handleRet(now, pm)


s = Solution()
# print(s.StrToInt("safd+we3"))
# print(s.StrToInt("safd+51we3"))
# print(s.StrToInt("safd-54we3"))
# print(s.StrToInt("safd57we3"))
# print(s.StrToInt("safd++57we3"))
print(s.StrToInt("99999999999999999999999999999999999999999999d++57we3"))

print(s.StrToInt("+82"))
print(s.StrToInt("   -12  "))
print(s.StrToInt("   --12  "))
print(s.StrToInt("4396 clearlove"))
print(s.StrToInt("clearlove 4396"))
print(s.StrToInt("-987654321111"))
print(s.StrToInt("-9876543+21111"))
