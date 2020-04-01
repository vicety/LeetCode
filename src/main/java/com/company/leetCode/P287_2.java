package com.company.leetCode;

public class P287_2 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;
            int next = nums[i];
            nums[i] = -1;
            while (true) {
                if (nums[next - 1] == next) return next;
                if (nums[next - 1] == -1) {
                    nums[next - 1] = next;
                    break;
                }
                int tmp = nums[next - 1];
                nums[next - 1] = next;
                next = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P287_2 p287_2 = new P287_2();
        System.out.println(p287_2.findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(p287_2.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
