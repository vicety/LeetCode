from collections import deque


def solution(A, X, Y):
    # write your code in Python (Python 3.6)
    q = deque()
    cur_sum = 0
    minn = int(2147483648)
    for y in range(Y):
        q.clear()
        ed = y
        for _ in range(X):
            if ed >= len(A):
                return minn
            q.append(A[ed])
            cur_sum += A[ed]
            ed += Y
        # ed: next position to consume
        minn = min(minn, cur_sum)
        while ed < len(A):
            cur_sum -= q.popleft()
            cur_sum += A[ed]
            q.append(A[ed])
            ed += Y
            minn = min(minn, cur_sum)
    return minn


print(solution([4, 2, 3, 7], 2, 2))
print(solution([10, 3, 4, 7], 2, 3))
print(solution([4, 2, 5, 4, 3, 5, 1, 4, 2, 7], 3, 2))

# 三题分别用时 9min 17min 16min
