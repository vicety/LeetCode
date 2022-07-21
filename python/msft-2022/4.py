def default_cmp(a, b):
    if a == b:
        return 0
    elif a < b:
        return -1
    else:
        return 1


# cmp(a, b): a>b->1 a==b->0 a<b->-1
def sort(arr, cmp=default_cmp):
    n = len(arr)
    for i in range(n - 1, 0, -1):
        for j in range(i):
            if cmp(arr[j], arr[j + 1]) > 0:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


for arr in [[1, 3, 2, 4], [], [1]]:
    sort(arr)


# sort([(1, 2), (3, 4)], )
