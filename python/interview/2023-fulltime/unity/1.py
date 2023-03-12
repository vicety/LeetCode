#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
#
# @param a int整型一维数组
# @param k int整型
# @return int整型
#
from typing import List


class Solution:
    def FillArray(self, a: List[int], k: int) -> int:
        # write code here

        mod = int(1e9 + 7)

        # k less than 1000
        # def solve(n, lowBound, highBound, ans):
        #     if n == 0:
        #         return ans
        #     for i in range(lowBound, highBound + 1):
        #         ans[0] = (ans[0] + solve(n - 1, lowBound))

        dp = [[0 for _ in range(1002)] for _ in range(1002)]

        # dp[1][0] = 1
        for j in range(1001):
            dp[1][j] = j + 1

        # num space, val space
        for i in range(2, 1001):  # n
            sm = 0
            for j in range(1001):  # val
                if j == 0:

                    dp[i][j] = dp[i - 1][j]
                else:
                    # dp[i][j] = dp[i-1][k] for k in range[0,j]
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod

        last = 1
        i = 0
        zero_cnt = 0
        ans = 1
        while i < len(a):
            if a[i] != 0:
                if zero_cnt > 0:
                    valSpace = a[i] - last
                    ans = (ans * dp[zero_cnt][valSpace]) % mod
                    zero_cnt = 0
                last = a[i]
            else:
                zero_cnt += 1
            i += 1
        if zero_cnt > 0:
            valSpace = k - last
            ans = (ans * dp[zero_cnt][valSpace]) % mod

        return ans


s = Solution()
print(s.FillArray([0, 4, 5], 6))
print(s.FillArray([0, 1, 0, 0], 3))
print(s.FillArray([0, 0, 0, 0, 0, 67, 0, 0], 100))
print(s.FillArray([0, 0, 3], 4))
