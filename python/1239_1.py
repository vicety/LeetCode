from typing import List


class Solution:
    def maxLength(self, arr: List[str]) -> int:
        if arr == None:
            return 0

        def isValidStr(s: str):
            return len(s) == len(set(s))

        validArr = list(filter(isValidStr, arr))
        return self.dfs(validArr, 0, "")

    def dfs(self, arr: List[str], curIdx: int, curStr: str) -> int:
        if curIdx == len(arr):
            return len(curStr)
        ret = self.dfs(arr, curIdx + 1, curStr)
        if len(set(curStr)) + len(set(arr[curIdx])) == len(set(curStr + arr[curIdx])):
            ret = max(ret, self.dfs(arr, curIdx + 1, curStr + arr[curIdx]))
        return ret
