class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        queryIP = queryIP.strip()
        if self.validateV4(queryIP):
            return "IPv4"
        elif self.validateV6(queryIP):
            return "IPv6"
        return "Neither"

    def validateV4(self, s: str):
        dotSplit = s.split(".")
        if len(dotSplit) != 4:
            return False
        for seg in dotSplit:
            if len(seg) == 0 or len(seg) > 3:
                return False

            if seg[0] == '0' and seg != '0':
                return False  # leading zero

            now = 0
            for c in seg:
                if ord(c) < ord('0') or ord(c) > ord('9'):
                    return False
                now *= 10
                now += ord(c) - ord('0')

            if now > 255:
                return False

        return True

    def validateV6(self, s: str):
        colonSplit = s.split(":")

        if len(colonSplit) != 8:
            return False

        for seg in colonSplit:
            if len(seg) == 0 or len(seg) > 4:
                return False

            now = 0
            i = 0
            for c in seg:
                if ord(c) >= ord('0') and ord(c) <= ord('9'):
                    i = ord(c) - ord('0')
                elif ord(c) >= ord('a') and ord(c) <= ord('f'):
                    i = 10 + ord(c) - ord('a')
                elif ord(c) >= ord('A') and ord(c) <= ord('F'):
                    i = 10 + ord(c) - ord('A')
                else:
                    return False

                now *= 16
                now += i

            if now > 65535:
                return False

        return True

s = Solution()
print(s.validIPAddress("2001:0Db8:A5a3:0000:0000:8a2e:0370:7334"))