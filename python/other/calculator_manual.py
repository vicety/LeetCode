def isNum(c):
    return ord("9") >= ord(c) >= ord("0")


op = ['+', '-', '*', '/']
opSet = set()
for o in op:
    opSet.add(o)

from collections import deque


def tokenize(expStr):
    token = []

    nowPtr = 0
    buf = ""

    # tokenize 过程
    while nowPtr < len(expStr):
        c = expStr[nowPtr]
        nowPtr += 1

        if isNum(c):
            buf += c
        elif c == " ":
            if buf:
                token.append(int(buf))
                buf = ""
        elif c == ')':
            if buf:
                token.append(int(buf))
                buf = ""
            token.append(c)
        else:
            if buf:
                token.append(int(buf))
                buf = ""
            token.append(c)
    if buf:
        token.append(int(buf))
    return token


def solve(expStr):
    token = tokenize(expStr)
    i = 0

    def solveInner():
        nonlocal i
        buf = ""
        numQ = deque()
        opQ = deque()
        while i < len(token):
            item = token[i]
            if isinstance(item, int):
                i += 1
                numQ.append(item)
            elif item in opSet:
                if i < len(token) and item == '*' or item == '/':
                    # 注意不能用 while，否则要处理这里连续拿到的可能是 (
                    i += 1
                    if token[i] == '(':
                        i += 1
                        newNum = solveInner()
                    else:
                        newNum = token[i]
                        # assert isinstance(newNum, int)
                    lastNum = numQ.pop()
                    if item == '*':
                        print(lastNum, newNum)
                        numQ.append(lastNum * newNum)
                    else:
                        numQ.append(lastNum // newNum)
                    i += 1
                if i < len(token) and item == '-' or item == '+':
                    opQ.append(item)
                    i += 1
            elif item == '(':
                i += 1
                numQ.append(solveInner())
                # print("after append {}. nowToken is {}".format(numQ[-1], token[i]))
            elif item == ')':
                i += 1
                num = numQ.popleft()
                while len(opQ):
                    op = opQ.popleft()
                    num1 = numQ.popleft()
                    if op == '+':
                        num += num1
                    else:
                        num -= num1
                return num

        num = numQ.popleft()
        while len(opQ):
            op = opQ.popleft()
            num1 = numQ.popleft()
            if op == '+':
                num += num1
            else:
                num -= num1
        return num

    return solveInner()


print(solve("20 / ((((5 * 6) - 6) / 2 + 9) + 1 - 2)"))
