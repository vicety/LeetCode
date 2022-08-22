# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S):
    # rally point
    # R2R1R
    # if rally at the rightmost R, will be 3 + 1 = 4
    # if rally at the leftmost R, will be 2 + 3 = 5
    # if rally at the middle R, will be 2 + 1 = 3
    # assume rally at leftmost, moving to middle meaning
    #   leftmost need more cost = 2, all position start from middle to rightmost need less cost = 2
    #   leading to 5 + 2 - 4
    # more generally, moving the rally point to next right (say k, diff by j) position meaning,
    #   cost add: count(where pos<k) * j
    #   cost reduce: count(where post>=k) * j
    # just traverse all possible rally point then

    # start at leftmost
    rList = []
    wList = []  # len should be len(rList) - 1
    rCnt = 0
    wCnt = 0
    firstR = True  # having met first R
    for c in S:
        if c == 'R':
            if not firstR and wCnt > 0:
                wList.append(wCnt)
            wCnt = 0
            firstR = False
            rCnt += 1
        else:
            if rCnt > 0:
                rList.append(rCnt)
                rCnt = 0
            wCnt += 1
    if rCnt > 0:
        rList.append(rCnt)
        rCnt = 0
    # print(rList, wList)

    if len(wList) == 0:
        return 0

    pR = 1
    dis = 0
    cost = 0
    while pR < len(rList):
        pW = pR - 1
        dis += wList[pW]
        cost += dis * rList[pR]
        pR += 1

    # now we have leftmost init cost
    # print(cost)
    ans = cost
    allR = sum(rList)
    leftR = 0
    for pR in range(0, len(wList)):
        leftR += rList[pR]
        rightR = allR - leftR
        cost += leftR * wList[pR]
        cost -= rightR * wList[pR]
        if cost < ans:
            ans = cost

    if ans > 1e9:
        return -1
    return ans


print(solution("RWRWRWR"))
print(solution("WWRRWW"))
print(solution("WWRRWRW"))
print(solution("WWRWRRW"))
print(solution("RRWWRR"))
