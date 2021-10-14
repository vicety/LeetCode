package com.company.leetCode;

public class P240 {
    // 向左找小，向下找大
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rightBound = matrix[0].length - 1;
        int upperBound = 0;
        while (rightBound >= 0 && upperBound < matrix.length) {
            if (matrix[upperBound][rightBound] > target) {
                int l = 0;
                while (rightBound >= l) {
                    int mid = l + (rightBound - l) / 2;
                    if (matrix[upperBound][mid] < target) l = mid + 1;
                    else if (matrix[upperBound][mid] > target) rightBound = mid - 1;
                    else return true;
                }
            } else if (matrix[upperBound][rightBound] < target) {
                int r = matrix.length - 1;
                while (upperBound <= r) {
                    int mid = upperBound + (r - upperBound) / 2;
                    if (matrix[mid][rightBound] < target) upperBound = mid + 1;
                    else if(matrix[mid][rightBound] > target) r = mid - 1;
                    else return true;
                }
            } else return true; // 这个else完全可以去掉，不过我觉得加上好看
        }
        return false;
    }
}
