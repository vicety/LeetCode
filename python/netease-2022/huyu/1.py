from functools import cmp_to_key

n = int(input())


def cmp(item1, item2):
    s1, diff1, n1, i1, o1 = item1
    s2, diff2, n2, i2, o2 = item2
    if s1 > s2 or s1 < s2:
        return s2-s1
    if diff1 > diff2 or diff1 < diff2:
        return diff2 - diff1
    if i1 > i2 or i2 > i1:
        return i2 - i1
    for i in range(min(len(n1), len(n2))):
        if ord(n1[i]) > ord(n2[i]) or ord(n1[i]) < ord(n2[i]):
            return ord(n1[i]) - ord(n2[i])
    return len(n1) - len(n2)


for _ in range(n):
    li = []
    di = {}
    for i in range(6):
        name, score, in1, out1 = input().split(' ')
        score = int(score)
        in1 = int(in1)
        out1 = int(out1)
        li.append((score, in1 - out1, name, in1, out1))
        di[name] = i

    for _ in range(3):
        name1, name2, in1, in2 = input().split(' ')
        in1 = int(in1)
        in2 = int(in2)

        s1, diff1, n1, i1, o1 = li[di[name1]]
        i1 += in1
        o1 += in2
        s2, diff2, n2, i2, o2 = li[di[name2]]
        i2 += in2
        o2 += in1

        if in1 > in2:
            li[di[name1]] = (s1 + 3, i1 - o1, n1, i1, o1)
            li[di[name2]] = (s2, i2 - o2, n2, i2, o2)
        elif in2 > in1:
            li[di[name1]] = (s1, i1 - o1, n1, i1, o1)
            li[di[name2]] = (s2 + 3, i2 - o2, n2, i2, o2)
        else:
            li[di[name1]] = (s1 + 1, i1 - o1, n1, i1, o1)
            li[di[name2]] = (s2 + 1, i2 - o2, n2, i2, o2)

    li.sort(key=cmp_to_key(cmp))

    for i in range(6):
        score, _, name, in2, out2 = li[i]
        print("{} {} {} {}".format(name, score, in2, out2))

    print("END")


# 2
# China 1 1 1
# Oman 1 1 1
# Japan 1 1 1
# Iran 1 1 1
# Thailand 1 1 1
# Vietam 1 1 1
# Iran Japan 0 0
# China Oman 0 0
# Thailand Vietam 0 0
# Indonesia 4 13 12
# Cyprus 4 14 17
# Singapore 7 18 20
# Cambodia 18 14 8
# Sikkim 17 13 14
# China 25 12 13
# Indonesia China 2 1
# Cyprus Singapore 3 0
# Cambodia Sikkim 3 3