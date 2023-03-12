n, p, q = list(map(lambda x: int(x), input().strip().split()))

st = list(map(lambda x: int(x), input().strip().split()))
ed = list(map(lambda x: int(x), input().strip().split()))
typ = input().strip().split()

stt = set()
for i in st: stt.add(i)
for i in ed: stt.add(i)
li = sorted(list(stt))
distToCon = dict()
conToDist = dict()
for i, item in enumerate(li):
    distToCon[i + 1] = item
    conToDist[item] = i + 1


class Node:
    def __init__(self):
        self.rng = 0
        self.data = [0, 0]  # 1, 2
        self.l = None
        self.r = None
        self.lazy = [0, 0]


data = [Node() for _ in range(len(li) * 4 + 10)]
print()


def build(rt, l, r):
    now = data[rt]
    now.l = l
    now.r = r
    if l == r:
        return
    mid = (now.l + now.r) // 2
    build(rt * 2, l, mid)
    build(rt * 2 + 1, mid + 1, r)


def add(rt, l, r, typ):
    now = data[rt]
    print(now.l, now.r, l, r)
    if now.l >= l and now.r <= r:
        if typ == '1':
            now.data[0] += 1
            now.lazy[0] += 1
        else:
            now.data[1] += 1
            now.lazy[1] += 1
        return
    # clear lazy
    lson = data[rt * 2]
    lson.lazy[0] += now.lazy[0]
    lson.lazy[1] += now.lazy[1]
    lson.data[0] += now.lazy[0]
    lson.data[1] += now.lazy[1]

    rson = data[rt * 2 + 1]
    rson.lazy[0] += now.lazy[0]
    rson.lazy[1] += now.lazy[1]
    rson.data[0] += now.lazy[0]
    rson.data[1] += now.lazy[1]

    now.lazy = [0, 0]

    mid = (now.l + now.r) // 2
    if (l <= mid): add(rt * 2, l, r, typ)
    if (r > mid): add(rt * 2 + 1, l, r, typ)
    now.rng = getN(lson) + getN(rson)


def getN(now):
    if now.data[0] >= p and now.data[1] >= q:
        realL = distToCon[now.l]
        realR = distToCon[now.r]
        return realR - realL + 1
    return 0


def query(rt, ql, qr):
    now = data[rt]
    if (ql <= now.l and qr >= now.r):
        return getN(now)

    # clear lazy
    lson = data[rt * 2]
    lson.lazy[0] += now.lazy[0]
    lson.lazy[1] += now.lazy[1]
    lson.data[0] += now.lazy[0]
    lson.data[1] += now.lazy[1]

    rson = data[rt * 2 + 1]
    rson.lazy[0] += now.lazy[0]
    rson.lazy[1] += now.lazy[1]
    rson.data[0] += now.lazy[0]
    rson.data[1] += now.lazy[1]

    now.lazy = [0, 0]

    mid = (now.l + now.r) // 2
    ans = 0
    if (ql <= mid): ans += query(rt * 2, ql, qr)
    if (qr > mid): ans += query(rt * 2 + 1, ql, qr)
    return ans


build(1, 1, len(li))
for i in range(n):
    stNow = conToDist[st[i]]
    edNow = conToDist[ed[i]]
    add(1, stNow, edNow, typ[i])

ans = 0

print(data[1].rng)

# 5 2 2
# 1 1 2 3 2
# 3 5 4 5 4
# 1 2 1 1 2

# 3
