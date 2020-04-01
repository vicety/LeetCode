package com.company.leetCode;

public class P268_3 {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                int next = nums[i];
                nums[i] = -1;
                while(next != nums.length) {
                    if(nums[next] == -1) {
                        nums[next] = next;
                        break;
                    }
                    int tmp = nums[next];
                    nums[next] = next;
                    next = tmp;
                }
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        P268_3 p268 = new P268_3();
        System.out.println(p268.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
