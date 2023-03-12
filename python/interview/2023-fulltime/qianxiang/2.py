# 示例 1：

# 输入：chars = ["a","a","b","b","c","c","c"]
# 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
# 解释："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
# 示例 2：

# 输入：chars = ["a"]
# 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
# 解释：唯一的组是“a”，它保持未压缩，因为它是一个字符。
# 示例 3：

# 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
# 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
# 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。

def solve(s):
    if len(s) == 0:
        return s

    i = 0
    writePtr = 0
    now = None
    nowCnt = 0
    while i < len(s):
        c = s[i]
        if c != now:
            if now:
                s[writePtr] = now
                writePtr += 1
                if nowCnt > 1:
                    while nowCnt:
                        s[writePtr] = nowCnt % 10
                        writePtr += 1
                        nowCnt //= 10
            now = c
            nowCnt = 1
        else:
            nowCnt += 1

        i += 1

    s[writePtr] = now
    writePtr += 1
    if nowCnt > 1:
        while nowCnt:
            s[writePtr] = nowCnt % 10
            writePtr += 1
            nowCnt //= 10
    return s


# 给一个数列，从中删掉一个数字，能否让剩下的数字从小到大排序后相邻数字的差值都是1

# for i in range(3):
# print('hello world')

# 1 2 2 3 4
# [0, 0, 0, 0]

def solve(arr):
    minn, maxx = min(arr), max(arr)
    trySet = []

    if maxx - minn + 1 <= len(arr) - 1:
        trySet.append(list(map(lambda x: x - minn, arr)))
    if maxx - minn + 1 > len(arr) - 1:
        withoutMaxx = []
        for num in arr:
            if num < maxx:
                withoutMaxx.append(num)
        if max(withoutMaxx) - min(withoutMaxx) + 1 <= len(arr) - 1:
            minn1 = minn(withoutMaxx)
            trySet.add(list(map(lambda x: x - minn1, withoutMaxx)))

        withoutMinn = []
        for num in arr:
            if num > minn:
                withoutMinn.append(num)
        if max(withoutMinn) - min(withoutMinn) + 1 <= len(arr) - 1:
            minn1 = minn(withoutMinn)
            trySet.add(list(map(lambda x: x - minn1, withoutMinn)))

    for tryArr in trySet:
        if solveFiltered(tryArr, len(arr) - 1):
            return True
    return False


def solveFiltered(arr, sz):
    slot = [False for _ in range(sz)]
    for num in arr:
        slot[num] = True
    for i in range(len(slot)):
        if not slot[i]:
            return False
    return True
