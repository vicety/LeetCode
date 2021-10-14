from typing import List


class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        vis = [False] * len(arr)

        def dfs(now):
            vis[now] = True
            if arr[now] == 0:
                return True
            right = now + arr[now]
            left = now - arr[now]
            if right < len(arr) and not vis[right]:
                if dfs(right):
                    return True
            if left >= 0 and not vis[left]:
                if dfs(left):
                    return True

        return dfs(start)
