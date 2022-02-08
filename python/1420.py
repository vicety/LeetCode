class Solution:
    def numOfArrays(self, n: int, m: int, k: int) -> int:
        # K个严格递增，第一个数字可用k-m+1个元素，第二个数字可用k-m+2个元素，etc
        # (a * b) mod n = ((a mod n) * (b mod n)) mod n
        if k > m or n < k:
            return 0
