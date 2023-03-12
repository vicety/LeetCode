n, m = list(map(lambda x: int(x), input().split()))
arr_original = list(map(lambda x: int(x), input().split()))

from queue import Queue

q = Queue()


def minIdx(arr, i):
    left = None
    leftMin = 99999999
    j = i - 1
    while j >= 0:
        if arr[j] == 0:
            break
        if arr[j] < leftMin:
            leftMin = arr[j]
            left = j
            break
        j -= 1
    j = i + 1
    right = None
    rightMin = 99999999
    while j < len(arr):
        if arr[j] == 0:
            break
        if arr[j] < rightMin:
            rightMin = arr[j]
            right = j
            break
        j += 1
    return left, right


def cp(arr):
    ret = []
    for num in arr:
        ret.append(num)
    return ret


mm = -1
mmin = 99999999
for i, num in enumerate(arr_original):
    if num < mmin:
        mmin = num
        mm = i

q.put((mm, cp(arr_original), 0, m))

ans = 0
while not q.empty():
    i, arr, cur, m_now = q.get()
    # print((i, arr, cur, m_now))
    num = arr[i]

    acc = 1
    arr[i] = 0
    j = i - 1
    while j >= 0 and arr[j] != 0:
        arr[j] -= num
        acc += 1
        j -= 1
    j = i + 1
    while j < len(arr) and arr[j] != 0:
        arr[j] -= num
        acc += 1
        j += 1
    m_now -= 1
    cur += acc * num
    if m_now == 0:
        ans = max(ans, cur)
    else:
        new_arr = cp(arr)
        leftIdx, rightIdx = minIdx(new_arr, i)
        if leftIdx is not None:
            q.put((leftIdx, new_arr, cur, m - 1))
        if rightIdx is not None:
            q.put((rightIdx, new_arr, cur, m - 1))

print(ans)
