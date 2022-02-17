class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if digits == "":
            return []

        mp = {}
        mp['2'] = "abc"
        mp['3'] = 'def'
        mp['4'] = 'ghi'
        mp['5'] = 'jkl'
        mp['6'] = 'mno'
        mp['7'] = 'pqrs'
        mp['8'] = 'tuv'
        mp['9'] = 'wxyz'
        results = []
        self.dfs(digits, 0, mp, "", results)
        return results

    def dfs(self, query, cur_idx, mp, cur_result, results):
        if cur_idx == len(query):
            results.append(cur_result)
            return
        c = query[cur_idx]
        for ch in mp[c]:
            self.dfs(query, cur_idx + 1, mp, cur_result + ch, results)