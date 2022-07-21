from typing import List


class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for val in asteroids:
            if val < 0:
                if not stack:
                    stack.append(val)
                else:
                    while stack and 0 < stack[-1] < -val:
                        stack.pop()
                    if stack and stack[-1] == -val:
                        stack.pop()
                    elif stack and stack[-1] > -val:
                        pass
                    else:
                        stack.append(val)
            else:
                stack.append(val)
        return stack
