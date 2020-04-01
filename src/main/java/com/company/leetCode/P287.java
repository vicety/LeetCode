package com.company.leetCode;

public class P287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;
            else {
                int now = nums[i];
                nums[i] = -1;
                do {
                    // System.out.println("now: " + now);
                    if (nums[now - 1] == -1) {
                        nums[now - 1] = now;
                        break;
                    } else if (nums[now - 1] == now) return now;
                    else {
                        int tmp = now;
                        now = nums[tmp - 1];
                        nums[tmp - 1] = tmp;
                    }
                } while (true);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        return -1;
    }
}
