import sys

n, m, k = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
commandLst = sys.stdin.readline().strip()

room = [[False for _ in range(m)] for _ in range(n)]
room[0][0] = True
y, x = 0, 0
remaining = m * n - 1
finish = 0
for i, c in enumerate(commandLst):
    if c == 'W':
        y -= 1
    elif c == 'A':
        x -= 1
    elif c == 'S':
        y += 1
    elif c == 'D':
        x += 1
    if not room[y][x]:
        remaining -= 1
        room[y][x] = True
        if remaining == 0:
            finish = i + 1

if remaining == 0:
    print("Yes")
    print(finish)
else:
    print("No")
    print(remaining)
