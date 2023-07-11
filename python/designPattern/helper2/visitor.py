# 其实我也不确定是不是

from python.designPattern.helper.visitor_helper import B


# visitor
class A:
    def __init__(self):
        pass

    def convertExpr(self, b: B):
        b.accept(self)

    def visit(self, b: B):
        print("a call b")
        pass

b = B()
a = A()
a.convertExpr(b)