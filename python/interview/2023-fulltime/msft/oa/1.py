# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S, B):
    # write your code in Python (Python 3.6)

    # fix  cost per
    # 1 -> 2    2
    # 2 -> 3    3/2
    # 3 -> 4    4/3

    # bigger always better than less
    option = []
    acc = 0
    for c in S:
        if c == 'x':
            acc += 1
        else:
            option.append(acc)
            acc = 0
    if acc != 0:
        option.append(acc)
    option = sorted(option)

    ans = 0
    while B > 0 and len(option):
        item = option.pop()
        cost = item + 1
        if cost < B:
            B -= cost
            ans += item
        else:
            ans += (B - 1)
            B = 0
    return ans


print(solution("...xxx..x....xxx.", 7))
print(solution("...xxxxx", 4))
print(solution("x.x.xxx...x", 14))
print(solution("..", 5))
