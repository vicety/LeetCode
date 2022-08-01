import queue


def solve():
    N = int(input())

    if N == 0:
        print("0")
        return

    nums = list(map(int, input().split(' ')))

    if N == 1:
        print("1")
        return

    q = queue.Queue()
    q.put(nums[0])
    i = 1
    ans = 0
    while i < N:
        a = nums[i]
        i += 1
        b = nums[i]
        i += 1
        root = q.get()
        if root != -1 and a == -1 and b == -1:
            ans += 1

        q.put(a)
        q.put(b)

    while q.queue:
        now = q.get()
        if now != -1:
            ans += 1

    print(ans)


solve()
