from typing import List


class Solution:
    def sumZero(self, n: int) -> List[int]:
        ans = []
        if n % 2 == 1:
            ans.append(0)
        time = n // 2
        num = 1
        for i in range(time):
            ans.append(-num)
            ans.append(num)
            num += 1

        return ans
