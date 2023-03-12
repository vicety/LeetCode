import sys

n, m, k = sys.stdin.readline().strip().split()
arr = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))

n = int(n)
m = int(m)
k = int(k)

repeat = [n]
for _ in range(60):
    repeat.append(repeat[-1] * 2)

# print(repeat)

k -= 1
dst = 0
for i in range(len(repeat)):
    if k < repeat[i]:
        dst = i
        break


def solve():
    if dst == 0:
        print(arr[k])
        return
    print(search(k, dst - 1, False))


def search(k, dst, rev):
    # print(k, dst, rev)
    if dst == -1:
        if not rev:
            return arr[k]
        else:
            return arr[::-1][k]
    if k >= repeat[dst]:
        k -= repeat[dst]
        if dst == 0:
            return search(k, dst - 1, True)
    return search(k, dst - 1, False)


solve()
