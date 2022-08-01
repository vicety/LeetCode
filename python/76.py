class Solution:
    def minWindow(self, s: str, t: str) -> str:
        l, r = 0, 0
        window = dict()
        target = dict()
        for c in t:
            window[c] = 0
            if not c in target:
                target[c] = 1
            else:
                target[c] += 1

        ans = ""
        minLength = float('inf')
        while r < len(s):
            if s[r] in target:
                window[s[r]] += 1

            while self.satisfy(window, target):
                if (r - l + 1) < minLength:
                    minLength = r - l + 1
                    ans = s[l:r + 1]
                if s[l] in t:
                    window[s[l]] -= 1
                l += 1
            r += 1

        return ans

    def satisfy(self, window, target):
        for k, v in target.items():
            if window[k] < v:
                return False
        return True


s = Solution()
print(s.minWindow("ADOBECODEBANC", "ABC"))
print(s.minWindow("a", "a"))
print(s.minWindow("a", "aa"))
