<<<<<<< HEAD
def solve(nums):
    if len(nums) == 1:
        return nums[0]
    if len(nums[0]) == 2:
        return max(nums[0], nums[1])

    return solveInner(nums, 0, len(nums - 1))


def solveInner(nums, l, r):
    while l < r:
        mid = (l + r) // 2

        if mid == 0:
            lvalue = float('-inf')
        else:
            lvalue = nums[mid - 1]
        if mid == len(nums-1):
            rvalue = float('-inf')
        else:
            rvalue = nums[mid + 1]

        value = nums[mid]
        if value > lvalue and value > rvalue:
            return value
        elif rvalue > value:
            l = mid + 1
        elif lvalue > value:
            r = mid - 1
        else:
            leftResult = solveInner(nums, l, mid - 1)
            if leftResult:
                return leftResult
            return solveInner(nums, mid + 1, r)

    return None


solve([1])
solve([1, 2])
solve([2, 1])
solve([1, 2, 1])
solve([1, 1, 1, 1, 1, 1, 1, 2])
solve([1, 2, 3, 2, 1])
