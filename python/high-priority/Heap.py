# 注意：思考为什么从非叶子节点开始

heap = [-1]  # dummy


def parent(i):
    return i // 2


def add(num):
    heap.append(num)
    up(len(heap) - 1)


def peek():
    if len(heap) == 1:
        return None
    return heap[1]


def pop():
    if len(heap) == 1:
        return None
    ret = heap[1]
    last = heap.pop()
    if len(heap) >= 2:
        heap[1] = last
        down(1)
    return ret


def up(i):
    p = parent(i)
    if p == 0:
        return
    pval = heap[p]
    val = heap[i]
    if val < pval:
        heap[p], heap[i] = val, pval
    up(p)


def down(i):
    if i * 2 > len(heap) - 1:
        return
    left = i * 2
    right = i * 2 + 1
    val = heap[i]
    lval = heap[left]
    if right > len(heap) - 1:
        rval = None
    else:
        rval = heap[right]

    min_child_idx = left
    if rval is not None and rval < lval:
        min_child_idx = right
    if heap[min_child_idx] > val:
        return
    heap[min_child_idx], heap[i] = heap[i], heap[min_child_idx]
    down(min_child_idx)


data = [3, 1, 4, 1, 5, 9, 2, 6]
for d in data:
    add(d)
while peek():
    print(pop())
