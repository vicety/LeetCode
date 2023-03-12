from collections import deque


# maintain a window sized N
class MovingAverage:

    def __init__(self, N):
        self.N = N
        self.window = deque()
        self.currentSum = 0

    def add(self, X):
        if len(self.window) == self.N:
            self.currentSum -= self.window.popleft()
        self.currentSum += X
        self.window.append(X)
        return self.currentSum / len(self.window)
