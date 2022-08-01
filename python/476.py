class Solution:
    def findComplement(self, num: int) -> int:
        dst = 0
        weight = 1
        while num != 0:
            if num % 2 == 0:
                dst += weight
            num //= 2
            weight *= 2
        return dst


s = Solution()
print(s.findComplement(5))
print(s.findComplement(2))
print(s.findComplement(1))
print(s.findComplement(2147483647))
