class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        s = s.replace("-", "")
        n = len(s) % k
        res = ""
        if n != 0:
            res = self.capitalize(s[:n]) + "-"
            s = s[n:]
        for i in range(0, len(s), k):
            res += self.capitalize(s[i:i + k]) + "-"
        return res[:-1]

    def capitalize(self, s):
        res = ""
        diff = ord('A') - ord('a')
        for c in s:
            if ord('a') <= ord(c) <= ord('z'):
                c = chr(ord(c) + diff)
            res += c
        return res


s = Solution()
print(s.licenseKeyFormatting("2", 1))
print(s.licenseKeyFormatting("5F3Z-2e-9-w", 4))
print(s.licenseKeyFormatting("2-5g-3-J", 2))
