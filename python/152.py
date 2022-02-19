class Solution:
    def maxProduct(self, nums) -> int:
        take_neg = None
        not_take_neg = None
        met_first_negative = False
        result = -2147483648

        for num in nums:
            if num == 0:
                take_neg = None
                not_take_neg = None
                met_first_negative = False
                result = max(result, 0)
            elif num > 0:
                if met_first_negative:
                    not_take_neg = self.assign(not_take_neg, num)
                take_neg = self.assign(take_neg, num)
            else:
                if met_first_negative:
                    not_take_neg = self.assign(not_take_neg, num)
                met_first_negative = True
                take_neg = self.assign(take_neg, num)

            if take_neg:
                result = max(result, take_neg)
            if not_take_neg:
                result = max(result, not_take_neg)

        return result

    def assign(self, var, val):
        if var is None:
            return val
        return var * val
