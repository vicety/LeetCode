//package com.company.leetCode;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//public class P66 {
//    public int[] plusOne(int[] digits) {
//        digits[digits.length - 1]++;
//        for (int i = digits.length - 2; i >= 0; i--) {
//            if (digits[i + 1] == 10) {
//                digits[i + 1] = 0;
//                digits[i]++;
//            }
//        }
//        if (digits[0] == 10) {
//            int[] tmp = new int[digits.length + 1];
//            System.arraycopy(digits, 0, tmp, 1, digits.length);
//            digits = tmp;
//            digits[0] = 1;
//            digits[1] = 0;
//        }
//        return digits;
//    }
//
//    private P66 self;
//
//    @Before
//    public void init() {
//        self = new P66();
//    }
//
//    @Test
//    public void test1() {
//        int[] input = new int[]{9, 9};
//        int[] expect = new int[]{1, 0, 0};
//        Assert.assertArrayEquals(expect, self.plusOne(input));
//    }
//}
