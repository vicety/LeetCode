class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        if len(s) == 0:
            return 0

        l, r, ans = 0, 1, 0
        while r <= len(s):
            if s[l] == s[r - 1]:
                r += 1
            else:
                strLen = r - l
                if strLen % 2 == 0 and s[l + strLen // 2] == s[r - 1]:
                    ans += strLen // 2
                    # reset the window
                    l = l + strLen // 2

                # 1111001
                r += 1
                if r <= len(s) and s[l] == s[r - 1]:
                    chL = s[l]
                    zero, one = 0, 0
                    for i in range(l, r - 1):
                        if s[i] != chL:
                            chL = s[i]
                            l = i
                        if s[i] == "0":
                            zero += 1
                        else:
                            one += 1
                    ans += min(zero, one)

        if s[l] != s[-1]:
            zero = 0
            one = 0
            for i in range(l, len(s)):
                if s[i] == "0":
                    zero += 1
                else:
                    one += 1
            ans += min(zero, one)

        return ans


S = Solution()
print(S.countBinarySubstrings("0001100"))
