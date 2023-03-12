s = input().strip()

qCnt = 0
for c in s:
    if c == '?':
        qCnt += 1


def toNum(c):
    return ord(c) - ord('0')


s = [c for c in s]

acc3 = 0

for c in s:
    if c != '?':
        acc3 += toNum(c)

nowQCnt = 0
for i, c in enumerate(s):
    if c == '?':
        nowQCnt += 1
        banned = set()
        if i > 0:
            banned.add(toNum(s[i - 1]))
        if i < len(s) - 1:
            banned.add(toNum(s[i + 1]))
        if i == 0:
            banned.add(0)
        for j in range(10):
            if j in banned:
                continue
            if nowQCnt == qCnt and (j + acc3) % 3 != 0:
                continue
            s[i] = chr(ord('0') + j)
            acc3 += toNum(s[i])
            break

print(''.join(s).strip())
