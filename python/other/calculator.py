def isNum(c):
    return ord("9") >= ord(c) >= ord("0")


class Exp:
    def __init__(self, l, op, r):
        self.l = l
        self.op = op
        self.r = r


def solve(expStr):
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

    tokenPtr = 0

    secondPriority = ["+", "-"]
    firstPriority = ["*", "/"]

    def parse():
        nonlocal tokenPtr
        c = token[tokenPtr]
        if c == '(':
            tokenPtr += 1
            res = parse()
            # ) 无法被下层处理，最终会返回
            tokenPtr += 1
            if tokenPtr == len(token) - 1:
                return res
            else:
                return handle2(res)
        elif isinstance(c, int):
            return handle2(None)

    def handle2(e):
        nonlocal tokenPtr
        e = handle1(e)
        while tokenPtr < len(token) and token[tokenPtr] in secondPriority:
            op = token[tokenPtr]
            tokenPtr += 1
            e = Exp(e, op, handle1(None))
        return e

    def handle1(e):
        nonlocal tokenPtr
        # must be num
        if e is None:
            e = token[tokenPtr]
            if e == '(':
                res = parse()
                return res
            # 如果前面已经有了 exp，是闭括号的情况，当前已经指向新 op 了，不需要向前
            # 否则是刚刚拿到数字作为起始 exp 的情况，向前
            tokenPtr += 1
        while tokenPtr < len(token) and token[tokenPtr] in firstPriority:
            op = token[tokenPtr]
            tokenPtr += 1
            num = token[tokenPtr]
            if num == '(':
                num = parse()
            tokenPtr += 1
            e = Exp(e, op, num)

        return e

    exp = parse()

    def eval_(exp):
        if isinstance(exp, int):
            return exp
        l = eval_(exp.l)
        r = eval_(exp.r)
        print("{} {} {}".format(l, exp.op, r))

        if exp.op == '+':
            return l + r
        elif exp.op == '-':
            return l - r
        elif exp.op == '*':
            return l * r
        elif exp.op == '/':
            return l // r

    return eval_(exp)


expStr = "20 / ((((5 * 6) - 6) / 2 + 9) + 1 - 2)"
print(solve(expStr))
