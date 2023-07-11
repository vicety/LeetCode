# 题目描述
# 有一个2*n的网格，有一个人位于(1,1)的位置，即左上角，他希望从左上角走到右下角，即(2,n)的位置。在每一次，他可以进行三种操作中的一种：
# 1． 向右走一格，即从(x,y)到(x,y+1);
# 2． 向右上方走一格，即，如果他在(2,y)的位置可以走到(1,y+1);
# 3． 向右下方走一格，即，如果他在(1,y)的位置可以走到(2,y+1);
#
# 问题当然不会这么简单，在这2*n的格子中，有一部分格子上有障碍物，他不能停在障碍物上，当然也不能走出网格，请问他有多少种不同的路线可以到达(2,n)。
#
# 输入
# 输入第一行仅包含一个正整数n，表示网格的长度。(1<=n<=50)
# 接下来有2行,每行有n个字符，“X”代表障碍物，“.”代表可以停留。
#
# 输出
# 如果没有可以到达的路线则输出-1，否则输出方案数量。
#
# 题目限制
# 时间限制：C/C++语言 1000MS；其他语言 3000 MS
# 内存限制：C/C++语言 65536KB；其他语言 589824KB
#
# 样例输入
# 5
# ..X.X
# XX...
#
# 样例输出
# 2

# coding=utf-8
import sys


# str = input()
# print(str)
# print('Hello,World!')

def solve(mp):
    n = len(mp[0])
    #     print(n)
    dp = [[0 for _ in range(n)] for _ in range(2)]

    dp[1][n - 1] = 1

    for i in range(n - 2, -1, -1):
        upperShare = 0 if mp[0][i + 1] == 'X' else dp[0][i + 1]
        lowerShare = 0 if mp[1][i + 1] == 'X' else dp[1][i + 1]

        if mp[0][i] != 'X':
            dp[0][i] = upperShare + lowerShare
        if mp[1][i] != 'X':
            dp[1][i] = upperShare + lowerShare

    #     print(dp)

    if dp[0][0] == 0:
        return -1

    return dp[0][0]


print(solve(["..X.X", "XX..."]))

# . . X . X
# X X . . .