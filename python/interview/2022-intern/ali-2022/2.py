import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    if n % 2 == 0:
        # 4 -> 0 0/1
        # 6 -> 6*1 1/2
        # 8 -> 8 * 1/3
        t = n // 2 - 1
        x = t // 2
        print(n * x)
    elif n == 3:
        print("1")
    else:
        t = (n - 1) // 2
        x = (t + 1) // 2
        print(n * x)
    # 3 1
    # 5 5 2->1
    # 7 2*7 3->2
    # 9 2*9 4->2
