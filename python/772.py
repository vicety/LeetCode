import sys


class Solution:
    def calculate(self, s: str) -> int:
        def clearShrink():
            if len(shrink) != 0 and shrink[-1] == left_parentheses:
                shrink.pop()
                num.append(self.cal(num.pop(), cur_num, op.pop()))
            else:
                num.append(cur_num)
            # cur_num = None

        num = []  # '( exist
        left_parentheses = 0
        op = []
        s += '$'
        shrink = []
        cur_num = None
        # shrink when existed */ and complete an operand
        # of existed ( and found )
        for c in s:
            if c == " ":
                pass
            elif c == "+" or c == "-":
                # (3*(1+2)), at same level of
                clearShrink()
                cur_num = None
                op.append(c)
            elif c == '*' or c == '/':
                clearShrink()
                cur_num = None
                shrink.append(left_parentheses)
                op.append(c)
            elif c == '(':
                left_parentheses += 1
                num.append('(')
            elif c == ')':
                # *2)
                if len(shrink) != 0 and shrink[-1] == left_parentheses:
                    shrink.pop()
                    cur_num = self.cal(num.pop(), cur_num, op.pop())
                # shrink ()
                numTmp = []
                opTmp = []
                while True:
                    n = num.pop()
                    if n == '(':
                        break
                    o = op.pop()

                    opTmp = [o] + opTmp
                    numTmp = [n] + numTmp
                numTmp.append(cur_num)
                cur_num = numTmp[0]
                i = 1
                while i < len(numTmp):
                    cur_num = self.cal(cur_num, numTmp[i], opTmp[i - 1])
                    i += 1

                left_parentheses -= 1
                if len(shrink) != 0 and shrink[-1] == left_parentheses:
                    shrink.pop()
                    cur_num = self.cal(num.pop(), cur_num, op.pop())
            elif c == '$':
                clearShrink()
                cur_num = num[0]
                i = 1
                while i < len(num):
                    cur_num = self.cal(cur_num, num[i], op[i - 1])
                    i += 1
                return cur_num

                # while len(num) != 0:
                #     cur_num = self.cal(num.pop(), cur_num, op.pop())
                # return cur_num
            else:
                if cur_num is None:
                    cur_num = 0
                cur_num = cur_num * 10 + (ord(c) - ord('0'))

    def cal(self, a, b, op):
        if op == '+':
            return a + b
        elif op == "-":
            return a - b
        elif op == '*':
            return a * b
        elif op == "/":
            sign = 1
            if a < 0:
                a = -a
                sign *= -1
            if b < 0:
                b = -b
                sign *= -1
            return sign * (a // b)
        else:
            sys.exit(-1)


s = Solution()
# print(s.calculate("2*(5+5*2)/3+(6/2+8)"))
# print(s.calculate("122"))
# print(s.calculate("(2+6*3+5-(3*14/7+2)*5)+3"))
# print(s.calculate("1*2-3/4+5*6-7*8+9/10"))
# print(s.calculate("2-4-(8+2-6+(8+4-(1)+8-10))"))
print(s.calculate("(0-3)/4"))
print(s.calculate("3/(2/1-4)"))


def f():
    return 1, 2
