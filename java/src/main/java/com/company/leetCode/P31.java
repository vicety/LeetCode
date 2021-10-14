package com.company.leetCode;

public class P31 {
    // 如123，最后一位比前一位大，那么换一下就可以,132
    // 如132，最后一位没有前一位大，那么这两位算是结束了，加上新的一位考虑，如果新一位也比之前两位大，那么这三位结束，
    // 否则将新一位替换为这两位中的较小值
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int prev = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] >= prev) prev = nums[i];
            else {
                int minBigger = Integer.MAX_VALUE;
                int j = i + 1;
                while (true) {
                    if(j == nums.length || nums[j] <= nums[i]) {
                        j--;
                        break;
                    }
                    minBigger = nums[j];
                    j++;
                }
                nums[j] = nums[i];
                nums[i] = minBigger;
                int base = i + 1;
                for(int k = 0; k < (nums.length - base) / 2; k++) {
                    int tmp = nums[base + k];
                    nums[base + k] = nums[nums.length - 1 - k];
                    nums[nums.length - 1 - k] = tmp;
                }
                break;
            }
            if(i == 0){
                for(int j = 0; j < nums.length / 2; j++) {
                    int tmp = nums[j];
                    nums[j] = nums[nums.length - 1 - j];
                    nums[nums.length - 1 - j] = tmp;
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        P31 p31 = new P31();
        p31.nextPermutation(new int[]{1, 1});
    }
}
