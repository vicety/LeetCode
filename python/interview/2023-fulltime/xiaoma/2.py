n, m = list(map(lambda x: int(x), input().split()))

mat = [['' for _ in range(m)] for _ in range(n)]

for row in range(n):
    line = input()
    for col, c in enumerate(line):
        mat[row][col] = c

from queue import Queue

q = Queue()
mem = dict()
ans = -1
vis = set()
for row in range(n):
    for col in range(m):
        q.put((row, col))

end = dict()


# def traverse(mat, nowi, nowj, vis):
#     # if nowi == 0 and nowj == 2:
#     #     print()
#     if nowi < 0 or nowi >= n or nowj < 0 or nowj >= m or (nowi, nowj) in vis:
#         return 0
#     vis.add((nowi, nowj))
#
#     nxt = (-1, -1)
#     if mat[nowi][nowj] == '^':
#         nxt = (-1, 0)
#     if mat[nowi][nowj] == 'v':
#         nxt = (1, 0)
#     if mat[nowi][nowj] == '<':
#         nxt = (0, -1)
#     if mat[nowi][nowj] == '>':
#         nxt = (0, 1)
#
#     res = traverse(mat, nowi + nxt[0], nowj + nxt[1], vis) + 1
#     mem[(nowi, nowj)] = res
#     return res

def traverse(mat, nowi, nowj, vis):
    ans = 0
    while True:
        if nowi < 0 or nowi >= n or nowj < 0 or nowj >= m or (nowi, nowj) in vis:
            return ans

        vis.add((nowi, nowj))

        nxt = (-1, -1)
        if mat[nowi][nowj] == '^':
            nxt = (-1, 0)
        if mat[nowi][nowj] == 'v':
            nxt = (1, 0)
        if mat[nowi][nowj] == '<':
            nxt = (0, -1)
        if mat[nowi][nowj] == '>':
            nxt = (0, 1)

        nowi, nowj = nowi + nxt[0], nowj + nxt[1]
        ans += 1


while not q.empty():
    startRow, startCol = q.get()
    ans_one = traverse(mat, startRow, startCol, set())
    # print(startRow, startCol, ans_one)
    ans = max(ans, ans_one)

print(ans)
