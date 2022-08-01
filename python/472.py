from typing import List


class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        words.sort(key=lambda x: len(x))

        if words[0] == "":
            words = words[1:]  # don't understand why "" is not considered a word

        ans = []
        st = set()
        for word in words:
            starts = [0]
            for i in range(len(word)):
                for start in starts:
                    if word[start:i + 1] in st:
                        starts.append(i + 1)
                        break
            if starts[-1] == len(word):
                ans.append(word)
            st.add(word)

        return ans


s = Solution()
datas = [
    [""],
    ["cat", "dog", "catdog"],
    ["cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"]
]

for data in datas:
    print(s.findAllConcatenatedWordsInADict(data))
