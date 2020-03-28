package com.company.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P264 {
    public int nthUglyNumber(int n) {
        List<Integer> now = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        now.add(1);
        for (int num : now) {
            tmp.add(num);
            while((long)num * 2 <= Integer.MAX_VALUE) {
                tmp.add(num * 2);
                num *= 2;
            }
        }
        now = tmp;
        tmp = new ArrayList<>();
        for (int num : now) {
            tmp.add(num);
            while((long)num * 3 <= Integer.MAX_VALUE) {
                tmp.add(num * 3);
                num *= 3;
            }
        }
        now = tmp;
        tmp = new ArrayList<>();
        for (int num : now) {
            tmp.add(num);
            while((long)num * 5 <= Integer.MAX_VALUE) {
                tmp.add(num * 5);
                num *= 5;
            }
        }
        tmp.sort(Comparator.comparingInt(a -> a));
        return tmp.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println((new P264()).nthUglyNumber(199));
    }
}
