# 给定一个数组，其中每个元素都是字符整数，并且是按照从小到大进行排序的。
# 给定一个字符串，也是整数，查找该字符串在数组中的位置。
# 如果不存在，返回-1.
# 假设没有重复
#
# 例如
# case 1:
#
# ["1","22","333"], "1"
# 输出:0
#
# case 2:
# ["1","22","333"], "4"
# -1

def solve(arr, query):
    l, r = 0, len(arr) - 1

    while l <= r:
        mid = (l + r) // 2
        val = arr[mid]
        cmpRes = cmp(query, val)
        if cmpRes == 1:  # query > mid
            l = mid + 1
        elif cmpRes == -1:
            r = mid - 1
        else:
            return mid
    return l


# 1 -> a > b
# 0 -> a == b
# -1 ->        a < b
def cmp(a: str, b: str):
    if len(a) > len(b):
        return 1
    elif len(a) < len(b):
        return -1
    for i in range(len(a)):
        if ord(a[i]) > ord(b[i]):
            return 1
        elif ord(a[i]) < ord(b[i]):
            return -1
    return 0


print(solve(["1", "22", "333"], "1"))
print(solve(["1", "22", "333"], "4"))
