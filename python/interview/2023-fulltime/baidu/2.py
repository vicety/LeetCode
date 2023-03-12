n = int(input())


def flip(s, i):
    if s[i] == '1':
        s[i] = '0'
    else:
        s[i] = '1'


for _ in range(n):
    s = input()
    scp = []
    for c in s: scp.append(c)
    s = scp
    scp = []
    for c in s: scp.append(c)
    for i in range(len(s) - 1):
        if s[i] != '0':
            flip(s, i)
            flip(s, i + 1)
    if s[len(s) - 1] == '0':
        print("Yes")
        continue
    s = scp
    for i in range(len(s) - 1):
        if s[i] != '1':
            flip(s, i)
            flip(s, i + 1)
    if s[len(s) - 1] == '1':
        print("Yes")
        continue
    print("No")
