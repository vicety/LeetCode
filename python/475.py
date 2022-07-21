from typing import List


class ListNode:
    def __init__(self, next1, prev, val):
        self.next = next1
        self.prev = prev
        self.val = val


class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        houses.sort()
        heaters.sort()
        head = ListNode(None, None, float('-inf'))
        tail = ListNode(None, head, float('inf'))
        head.next = tail
        for heater in heaters:
            prev = tail.prev
            newNode = ListNode(tail, prev, heater)
            tail.prev = newNode
            prev.next = newNode
        ans = 0
        now = head
        for house in houses:
            while house >= now.next.val:
                now = now.next
            ans = max(ans, min(house - now.val, now.next.val - house))
        return ans


s = Solution()
print(s.findRadius([1, 2, 3, 4], [1, 4]))
