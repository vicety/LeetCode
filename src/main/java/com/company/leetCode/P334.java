package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P334 {
    public boolean increasingTriplet(int[] nums) {
        List<Integer> increase = new ArrayList<>();
        for (int num : nums) {
            if (increase.isEmpty()) increase.add(num);
            else {
                if (num > increase.get(increase.size() - 1)) increase.add(num);
                else if (num < increase.get(increase.size() - 1)) {
                    if (num <= increase.get(0)) increase.set(0, num);
                    else increase.set(1, num);
                }
            }
            if (increase.size() == 3) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        P334 p334 = new P334();
        System.out.println(p334.increasingTriplet(new int[]{1, 2, 1, 2}));
    }
}
