from queue import PriorityQueue


def solution(A):
    # write your code in Python (Python 3.6)
    A = list(map(lambda x: float(x), A))
    total = sum(A)
    q = PriorityQueue()
    gain = 0.0
    for item in A:
        q.put(-item)
    cnt = 0
    while gain < total / 2:
        item = q.get()
        val = -item
        val /= 2
        gain += val
        q.put(-val)
        cnt += 1
    return cnt


print(solution([5, 9, 18, 1]))
print(solution([10, 10]))
print(solution([3, 0, 5]))
