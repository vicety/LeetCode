import sys

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def validPoint(y, x):
    return 0 <= y < 4 and 0 <= x < 4


def hasRemain(x, y):
    for i in range(-1, 2, 1):
        for j in range(-1, 2, 1):
            if i == 0 and j == 0:
                continue
            x1 = x + i
            y1 = y + j
            if


def judge(mp, predict):
    for i in range(4):
        for j in range(4):
            if mp[i][j] != '.':
                n = int(mp[i][j])
                for dx in range(-1, 2, 1):
                    for dy in range(-1, 2, 1):
                        if i == 0 and j == 0:
                            continue


def solve(st, n, mp):
    if n == len(st):



if __name__ == "__main__":
    toJudge = set()
    mark = dict()

    mp = [['.' for _ in range(4)] for _ in range(4)]
    for i in range(4):
        line = sys.stdin.readline().strip()
        values = line.split()
        for j in range(4):
            if ord('1') <= ord(values[j][0]) <= ord('9'):
                val = int(values[j])
                mp[i][j] = values[j]
                mark[(i, j)] = val
            else:
                toJudge.add((i, j))

    st = []
    for p in toJudge:
        st.append(p)
    while len(st):


    mpCp = [['.' for _ in range(4)] for _ in range(4)]
    for i in range(4):
        for j in range(4):
            if mp[i][j] != '.':
                mpCp[i][j] = mp[i][j]
