# lintcode 849
class Solution:
    """
    @param s: the expression string
    @return: the answer
    """

    def calculate(self, s):
        # Write your code here
        return self.cal(s, 0)[0]

    def cal(self, s, st):
        vals = []
        now = 0
        op = "+"
        i = st
        while i < len(s):
            c = s[i]
            if self.isDigit(c):
                now = now * 10 + (ord(c) - ord("0"))
            elif c == "+" or c == "-" or c == "*" or c == "/":
                self.compute(vals, op, now)
                now = 0
                op = c
            elif c == '(':
                now, i = self.cal(s, i + 1)
            elif c == ')':
                self.compute(vals, op, now)
                return sum(vals), i
            else:
                pass
            i += 1
        # return num, end_pos

        self.compute(vals, op, now)
        return sum(vals), -1

    def compute(self, vals, prevOp, now):
        if prevOp == "+":
            vals.append(now)
        elif prevOp == "-":
            vals.append(-now)
        elif prevOp == "*":
            vals[-1] *= now
        elif prevOp == "/":
            vals[-1] //= now

    def isDigit(self, c):
        return "0" <= c <= "9"


s = Solution()
print(s.calculate("1+4/2"))
print(s.calculate("2*(4+2/2)"))
print(s.calculate("2/(2-1)"))
s = set()
