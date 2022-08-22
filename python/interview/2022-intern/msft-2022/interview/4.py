def solve(nums):
    if len(nums) == 1:
        return nums[0]
    if len(nums) == 2:
        return max(nums[0], nums[1])

    return solveInner(nums, 0, len(nums) - 1)


def solveInner(nums, l, r):
    # print(l, r)
    while l <= r:
        mid = (l + r) // 2

        if mid == 0:
            lvalue = float('-inf')
        else:
            lvalue = nums[mid - 1]
        if mid == len(nums) - 1:
            rvalue = float('-inf')
        else:
            rvalue = nums[mid + 1]

        value = nums[mid]
        # print("mid {} {} {} {}".format(mid, lvalue, value, rvalue))
        if value > lvalue and value > rvalue:
            return value  # 找峰值，先上升后下降，可能不止一个，存在相同值
        elif rvalue > value:
            l = mid + 1
        elif lvalue > value:
            r = mid - 1
        else:  # 谷值
            leftResult = solveInner(nums, l, mid - 1)
            if leftResult is not None:
                return leftResult
            return solveInner(nums, mid + 1, r)

    return None


print(
    solve([1]),
    solve([1, 5]),
    solve([2, 1]),
    solve([1, 2, 1]),
    solve([1, 1, 1, 1, 1, 1, 1, 7]),
    solve([1, 2, 3, 2, 1]),
    solve([1, 2, 3, 2, 1, 2, 1]),
    solve([1, 2, 2, 2, 1, 1, 1])
)
