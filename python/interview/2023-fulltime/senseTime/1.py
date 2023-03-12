#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 图像旋转
# @param img int整型二维数组 输入图像
# @return int整型二维数组
#
class Solution:
    def rotate_img(self, img):
        # write code here
        n = len(img)
        m = len(img[0])
        ans = []
        for i in range(0, m):
            row = []
            for j in range(n - 1, -1, -1):
                row.append(img[j][i])
            ans.append(row)
        return ans


s = Solution()
s.rotate_img([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
