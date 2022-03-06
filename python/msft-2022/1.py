def solution(S):
    # write your code in Python 3.6
    arr = [True] * len(S)
    ans = 0
    for i, c in enumerate(S):
        if c == '<' and (i - 1 < 0 or not arr[i - 1]):
            arr[i] = False
            ans += 1
            if i - 1 >= 0:
                arr[i - 1] = True
        elif c == '>' and (i + 1 >= len(S) or not arr[i + 1]):
            arr[i] = False
            ans += 1
            if i + 1 < len(S):
                arr[i + 1] = True
        elif c == '^' or c == 'v':
            arr[i] = False
            ans += 1

    return ans