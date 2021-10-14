class Solution:
    def minDeletions(self, s: str) -> int:
        # return ans
        pass

    # def minDeletions(self, s: str) -> int:
    #     c_to_freq = {}
    #     freq_to_c = {}
    #
    #     for c in s:
    #         c_to_freq[c] = c_to_freq.get(c, 0) + 1
    #         freq = c_to_freq[c]
    #         freq_to_c[freq - 1] = freq_to_c.get(freq - 1, set())
    #         if c in freq_to_c[freq - 1]:
    #             freq_to_c[freq - 1].remove(c)
    #         freq_to_c[freq] = freq_to_c.get(freq, set())
    #         freq_to_c[freq].add(c)
    #
    #     ans = 0
    #     hasDuplicate = True
    #     while hasDuplicate:
    #         hasDuplicate = False
    #         for freq, st in freq_to_c.items():
    #             if len(st) < 2:
    #                 continue
    #
    #             for c in st:
    #                 ans += 1
    #                 freq_to_c[freq].remove(c)
    #                 if freq != 1:
    #                     freq_to_c[freq - 1] = freq_to_c.get(freq - 1, set())
    #                     freq_to_c[freq - 1].add(c)
    #                 hasDuplicate = True
    #                 break
    #
    #             if hasDuplicate:
    #                 break
    #
    #     return ans


s = Solution()
print(s.minDeletions("aab"))
print(s.minDeletions("aaabbbcc"))
print(s.minDeletions("ceabaacb"))
