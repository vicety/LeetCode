class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return "0"

        result = "0"
        for i in range(len(num1)):
            for j in range(len(num2)):
                ch1 = num1[len(num1) - 1 - i]
                ch2 = num2[len(num2) - 1 - j]
                base = i + j
                result = self.strAdd(result,
                                     self.multiplyOneDigit(ch1, ch2, base))
        return result

    def multiplyOneDigit(self, s1, s2, base) -> str:
        digit = (ord(s1) - ord('0')) * (ord(s2) - ord('0'))
        result = ""
        while True:
            result += chr(ord('0') + digit % 10)
            digit = digit // 10
            if digit == 0:
                break
        result = reverseStr(result)
        while base > 0:
            result += "0"
            base -= 1
        return result

    def strAdd(self, s1, s2) -> str:
        s1 = reverseStr(s1)
        s2 = reverseStr(s2)
        result = ""
        carry = 0
        p1 = 0
        p2 = 0
        while p1 < len(s1) and p2 < len(s2):
            tmp = (ord(s1[p1]) - ord('0')) + (ord(s2[p2]) - ord('0')) + carry
            carry = tmp // 10
            result += chr((tmp % 10) + ord('0'))
            p1 += 1
            p2 += 1
        while p1 < len(s1):
            tmp = (ord(s1[p1]) - ord('0')) + carry
            carry = tmp // 10
            result += chr((tmp % 10) + ord('0'))
            p1 += 1
        while p2 < len(s2):
            tmp = (ord(s2[p2]) - ord('0')) + carry
            carry = tmp // 10
            result += chr((tmp % 10) + ord('0'))
            p2 += 1
        if carry != 0:
            result += "1"

        return reverseStr(result)


def reverseStr(s) -> str:
    ret = ""
    for i in range(len(s)):
        ret += s[len(s) - 1 - i]
    return ret


s = Solution()
print(s.multiply("0", "3777"))
