def solve(arr):
    used = 0
    unused = 0

    ans = 0

    for item in arr:
        if item == 0:
            used = unused + 1
            unused = 0
        else:
            used += 1
            unused += 1

        ans = max(ans, used, unused)

    return ans


print(solve([1, 0, 1, 1, 0]))