t = int(input())
for _ in range(t):
    a, b = list(map(int, input().strip().split()))
    rev = False
    if a > b:
        rev = not rev
        a, b = b, a
    # b > a
    y = b
    x = a + b
    # x % y = a | y % x = b
    if a == 0 and b == 0:
        print("1 1")
    elif a == 0:
        print("-1 -1")
    elif b == 0:
        print("-1 -1")
    else:
        if not rev:
            print("{} {}".format(x, y))
        else:
            print("{} {}".format(y, x))
