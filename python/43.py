class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return "0"

        result = "0"
        for i in range(len(num2)):
            ch = num2[len(num2) - 1 - i]
            result = self.strAdd(result, self.multiplyOneDigit(num1, ch, i))

        return result.lstrip("0")

    def multiplyOneDigit(self, num1, num2, base):
        result = ""
        carry = 0
        num1 = reverseStr(num1)
        for i in range(len(num1)):
            ch = num1[i]
            tmp = (ord(num2) - ord('0')) * (ord(ch) - ord('0')) + carry
            result += str(tmp % 10)
            carry = tmp // 10
        if carry != 0:
            result += str(carry)

        result = reverseStr(result)

        while base != 0:
            base -= 1
            result += "0"
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
print(s.multiply("0", "0"))
