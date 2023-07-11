from python.designPattern.helper2.visitor import A

class B:
    def accept(self, a: A):
        print("at B")
        a.visit(self)

