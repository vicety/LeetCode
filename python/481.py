class Solution:
    def magicalString(self, n: int) -> int:
        nums = [1, 2, 2]
        p = 2
        ans = 1
        while len(nums) < n:

            if nums[-1] == 1:
                new_num = 2
            else:
                new_num = 1

            flag = False
            for _ in range(nums[p]):
                nums.append(new_num)
                if new_num == 1:
                    ans += 1
                if len(nums) == n:
                    flag = True
                    break

            if flag:
                break

            p += 1

        return ans


s = Solution()
print(s.magicalString(6))
