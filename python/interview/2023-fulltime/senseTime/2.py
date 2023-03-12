#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
#
# @param nums int整型一维数组
# @param k int整型
# @return int整型一维数组
#
class Solution:
    def topKFrequent(self, nums, K):
        # write code here
        di = dict()
        for num in nums:
            di[num] = di.get(num, 0) + 1
        freq = []
        for k, v in di.items():
            freq.append((-v, k))
        freq = sorted(freq)
        freqTopK = freq[:K]
        return sorted(list(map(lambda x: x[1], freqTopK)))


s = Solution()
print(s.topKFrequent([1, 1, 1, 2, 2, 3], 2))
