nums = [[4, 3, 2], [3, 2, 1], [5, 4, 3]]


# from queue import PriorityQueue
class PriorityQueue:
    def __init__(self):
        self.arr = []

    def get(self):
        ret = self.arr[0]
        self.arr[0] = self.arr[len(self.arr) - 1]
        self.arr = self.arr[:-1]
        self.down(0)
        return ret

    def put(self, val):
        self.arr.append(val)
        self.up(len(self.arr) - 1)

    def up(self, i):
        if i == 0:
            return
        fa = (i - 1) // 2
        if self.arr[fa] > self.arr[i]:
            self.arr[fa], self.arr[i] = self.arr[i], self.arr[fa]
        self.up(fa)

    def down(self, i):
        if i >= len(self.arr):
            return
        l = i * 2 + 1
        r = i * 2 + 2
        val = self.arr[i]
        print(l, r, val)
        if l < len(self.arr):
            lval = self.arr[l]
        else:
            lval = None
        if r < len(self.arr):
            rval = self.arr[r]
        else:
            rval = None
        if not lval and not rval:
            return
        elif lval and not rval:  # lval evals to false?
            if val > lval:
                self.arr[i], self.arr[l] = self.arr[l], self.arr[i]
                self.down(l)
        elif lval < rval and lval < val:
            self.arr[i], self.arr[l] = self.arr[l], self.arr[i]
            self.down(l)
        elif rval < lval and rval < val:
            self.arr[i], self.arr[r] = self.arr[r], self.arr[i]
            self.down(r)
        return


def solve(k):
    ans = []
    n = len(nums)
    m = len(nums[0])
    heap = PriorityQueue()
    for i in range(n):
        heap.put((-nums[i][0], i, 0))
    for _ in range(k):
        num, row, col = heap.get()
        ans.append(-num)
        if col < m - 1:
            heap.put((-nums[row][col + 1], row, col + 1))
    print(ans)


solve(9)
