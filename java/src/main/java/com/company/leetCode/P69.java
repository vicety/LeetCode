package com.company.leetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class P69 {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int l = 1;
        int r = Integer.MAX_VALUE;
        while(true) {
            int mid = l + (r - l) / 2;
            System.out.println(String.format("%d %d %d %d %d", l, r, mid, x / mid, x / (mid + 1)));
            if(mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            else if(mid > x / mid) r = mid - 1;
            else l = mid + 1;
        }
    }

    public static void main(String[] args) {
        P69 p69 = new P69();
        System.out.println(p69.mySqrt(17));
//        System.out.println(2 + (2 - 2) >> 1);
        Stack<Integer> st = new Stack<>();
        Deque<Integer> dq = new LinkedList<>();
        dq.poll();
    }
}
