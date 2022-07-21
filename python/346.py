from collections import deque

class MovingAverage(object):
    """
    @param: size: An integer
    """

    def __init__(self, size):
        # do intialization if necessary
        self.window = deque()
        self.size = size
        self.window_sum = 0

    """
    @param: val: An integer
    @return:  
    """

    def next(self, val):
        self.window.append(val)
        if len(self.window) <= self.size:
            self.window_sum += val
        else:
            first = self.window.popleft()
            self.window_sum += val - first
        return self.window_sum / len(self.window)

# write your code here

# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param = obj.next(val)
