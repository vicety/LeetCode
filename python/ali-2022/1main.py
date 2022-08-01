import functools


def solve(arr):
    def cmp(a, b):
        ab = a + b
        ba = b + a
        if ab > ba:
            return -1
        elif ab < ba:
            return 1
        return 0

    arr_str = list(map(lambda num: str(num), arr))
    arr_str = sorted(arr_str, key=functools.cmp_to_key(cmp))
    print("".join(arr_str))

solve([0,0])
