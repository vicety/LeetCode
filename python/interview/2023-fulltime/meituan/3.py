import sys

n = int(input())
nums = list(map(lambda x: int(x), sys.stdin.readline().strip().split()))


class ListNode:
    def __init__(self, val):
        self.index = 0
        self.val = val
        self.next = None


# build list
dumb = ListNode(-1)
now = dumb
prev = None
for i in range(1, n + 1):
    now.next = ListNode(i)
    now = now.next
head = dumb.next
now.next = head

# now we have a circle, head point to 1
order = []
now = dumb
while True:
    now = now.next.next
    next = now.next
    skipNext = now.next.next
    if next.val == skipNext.val:
        order.append(next.val)
        break
    order.append(next.val)
    now.next = skipNext
# print(order)
ans = [0] * n
for i in range(n):
    # print(order[i] - 1)
    ans[order[i] - 1] = nums[i]
print(" ".join(list(map(lambda x: str(x), ans))))
