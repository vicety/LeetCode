from typing import List


class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        if bits == [0] or bits[-2:] == [0, 0]:  # ensure len >= 1 and ends with 0
            return True
        # must ends with [1, 0], see if could be decoded for the rest part
        query = bits[:-2]
        dp = [0] * (len(query) + 1)
        dp[0] = 1
        for i, c in enumerate(query):
            if c == 0 and dp[i] == 1:
                dp[i + 1] = 1
            if i > 0 and dp[i - 1] == 1 and ((query[i - 1], c) == (1, 0) or (query[i - 1], c) == (1, 1)):
                dp[i + 1] = 1

        return dp[len(query)] != 1


s = Solution()
# print(s.isOneBitCharacter([0]))
# print(s.isOneBitCharacter([0, 0]))
# print(s.isOneBitCharacter([1, 0]))
# print(s.isOneBitCharacter([1, 1, 0]))
# print(s.isOneBitCharacter([0, 1, 0]))
# print(s.isOneBitCharacter([1, 0, 0]))
print(s.isOneBitCharacter([1, 1, 1, 0]))
