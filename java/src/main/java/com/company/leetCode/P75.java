package com.company.leetCode;

public class P75 {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] == 0) {
                nums[i] = nums[l];
                nums[l++] = 0;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[r];
                nums[r--] = 2;
            } else i++;
        }
    }


    public static void main(String[] args) {
//        P75 p75 = new P75();
//        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
//        p75.sortColors(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        System.out.println(127877 == 127877);
    }
}
