import sys

n = int(sys.stdin.readline().strip())


def solve(num):
    if num == 1:
        return "1"
    di = dict()
    di[2] = "1120"
    di[3] = "11120"
    last1, last2, n = 2, 3, 4

    for _ in range(20):
        acc = last1 + last2
        di[acc] = "1" * n + "20"
        n += 1
        last1 = last2
        last2 = acc

    ans = ""
    for k, v in di.items():
        while num % k == 0:
            num //= k
            ans += v

    if num == 1:
        return ans
    else:
        return -1


print(solve(n))
# if n < 100000:
#     ans = ""
#     for _ in range(n):
#         ans += "9"
#     print(ans)
# else:
#     print(-1)

# mp = dict()
# for i in range(26):
#     mp[str(i)] = chr(ord('a') + i)
#
#
# def solve():
#     def dfs(idx, cur, N):
#         if idx == len(line) and N ==:
#             print(cur)
#             return True
#         nxtCh =
#
# print(solve())

# 111 -> 1 11
# 123 -> 1 2 3 12 23
# 111 -> solve(1)*solve(11) + solve(11)+solve(1)

# 1-9 11-9

# 999 -> 1
# 111 9 -> 3

# 10 才是 barrier
# 11 10 -> 2
# 111 10 -> 3
# 1111 -> (1) 111 + (11) 11 = 3+2 = 5
# 11111 -> solve(3) + solve(4) = 8

# 13 -> 2
# 13|1 -> 2

# 1919 20 -> 19 | 19 -> 4
# 51

# 1113 = 111 + 11