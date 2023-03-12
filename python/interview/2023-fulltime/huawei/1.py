# If you need to import additional packages or classes, please import here.

# 听说都是 100 多分

# 多字段排序

import sys


def func():
    nArea = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))[0]
    msgIdToUser = dict()
    usersDi = dict()
    for _ in range(nArea):
        mid, _ = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
        users = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))
        for user in users:
            if usersDi.get(user) is None:
                usersDi[user] = [0, user, dict()]  # n, name
            if usersDi[user][2].get(mid) is None:
                usersDi[user][2][mid] = 0
            usersDi[user][2][mid] -= 1  # msgArea, num
            usersDi[user][0] -= 1

    srtd = list(usersDi.values())
    srtd.sort()
    # print(srtd)
    for userItem in srtd:
        userId = userItem[1]
        visMsg = userItem[2]
        li = list(map(lambda x: (x[1], x[0]), list(visMsg.items())))
        li.sort()
        strr = ",".join(map(lambda x: str(x[1]), li))
        print("{}:{}".format(userId, strr))

    # please define the python3 input here. For example: a,b = map(int, input().strip().split())
    # please finish the function body here.
    # please define the python3 output here. For example: print().


if __name__ == "__main__":
    func()

# 3
# 1 3
# 1 12 12
# 2 1
# 12
# 3 2
# 11 102
