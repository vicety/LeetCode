class Solution:
    def minFlips(self, target: str) -> int:
        ans = 0
        current = "0"
        for c in target:
            if c == current:
                continue
            current = c
            ans += 1
        return ans