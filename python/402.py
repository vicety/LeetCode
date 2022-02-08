class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        preZero = 0
        while preZero < len(num) and num[preZero] == "0":
            preZero += 1

        num = num[preZero:]

        if k >= len(num):
            return "0"
        if k == 0:
            return num
        if self.asc(num):
            return self.removeKdigits(num[:len(num) - 1], k - 1)
        for i in range(len(num)):
            if num[i] > num[i + 1]:
                return self.removeKdigits(num[:i] + num[i + 1:], k - 1)

    def asc(self, nums):
        if len(nums) < 2:
            return True
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                return False
        return True


S = Solution()
print(S.removeKdigits("1432219", 3))
print(S.removeKdigits("10000", 3))
print(S.removeKdigits("10200", 1))
print(S.removeKdigits("10", 2))
