package com.company.jianzhi;

public class P1 {
//    public boolean Find(int target, int[][] array) {
//        if (array == null || array[0].length == 0) return false;
//        int rightBound = array[0].length - 1;
//        int upperBound = 0;
//
//        int l = 0;
//        int r = array[0].length;
//        while(l < r) {
//            int mid = (l + r) >> 1;
//            if(array[0][mid] == target) return true;
//            else if(array[0][mid] < target) l = mid + 1;
//            else r = mid - 1;
//        }
//        rightBound = r;
//        while (rightBound >= 0 && upperBound <= array.length - 1) {
//            l = upperBound;
//            r = array.length;
//            while(l < r) {
//                int mid = (l + r) >> 1;
//                if(array[mid][rightBound] == target) return true;
//                else if(array[mid][rightBound] < target) l = mid + 1;
//                else r = mid - 1;
//            }
//            upperBound = r;
//            rightBound--;
//        }
//        return false;
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rightBound;
        int upperBound = 0;

        int l = 0;
        int r = matrix[0].length - 1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(matrix[0][mid] == target) return true;
            else if(matrix[0][mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        rightBound = r;
        while (rightBound >= 0 && upperBound <= matrix.length - 1) {
            System.out.println(String.format("%d %d", upperBound, rightBound));
            l = upperBound;
            r = matrix.length - 1;
            while(l <= r) {
                int mid = (l + r) >> 1;
                if(matrix[mid][rightBound] == target) return true;
                else if(matrix[mid][rightBound] < target) l = mid + 1;
                else r = mid - 1;
            }
            upperBound = r;
            rightBound--;
        }
        return false;
    }
}

