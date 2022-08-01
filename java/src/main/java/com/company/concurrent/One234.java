package com.company.concurrent;

import sun.nio.cs.Surrogate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class One234 {

}

class Printer {
    private int val;
    private int cnt;
    private Condition prev;
    private Condition next;
    private Lock lock;

    public void print() {

    }

    public static void main(String[] args) {
        String s = "a\uD83D\uDE03\uD83D\uDE2B";
        // char数组第i个，处于high surrogate区间，无法打印，打印出?
        System.out.println(s.charAt(1));
        System.out.println(Character.isHighSurrogate(s.charAt(1))); // true
        System.out.println(Character.isHighSurrogate('a')); // false
        System.out.println(Character.isLowSurrogate(s.charAt(2))); // true
        // 第i个字符的unicode -> 😃=0x1F603=128515
        System.out.println(s.codePointAt(1));
        // 第1个字符的unicode对应几个char -> 2
        System.out.println(Character.charCount(s.codePointAt(1)));
        // char数组长度 -> 5
        System.out.println(s.length());
        // 字符数量 -> 3
        System.out.println(s.codePointCount(0, s.length()));
        System.out.println(s.codePointCount(0, 1)); // 1
        System.out.println(s.codePointCount(0, 2)); // 2
        System.out.println(s.codePointCount(0, 3)); // 2
        // 从char数组index=1开始，偏移2个字符后的char index -> 5
        System.out.println(s.offsetByCodePoints(1, 2));
        // 逐个字符打印s
        int chCnt = s.codePointCount(0, s.length());
        int st = 0;
        int ed;
        for (int i = 0; i < chCnt; i++) {
            ed = s.offsetByCodePoints(st, 1);
            System.out.println(s.substring(st, ed));
            st = ed;
        }

//        System.out.println("😀😂".offsetByCodePoints(0, 2));
//        String testCode = "ab\uD83D\uDE03cd"; // 😃😫
//        Character.isHighSurrogate(testCode.offsetByCodePoints(0, ))
//        int cpCount = testCode.codePointCount(0, testCode.length());
//        for (int index = 0; index < cpCount; ++index) {
//            //这里的i是字符的位置
//            int i = testCode.offsetByCodePoints(0, index);
//            int codepoint = testCode.codePointAt(i);
//            System.out.printf("%d %d\n", i, codepoint);
//        }
    }

    static int codePointsLength(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); ) {
            int codePoint = s.codePointAt(i);
            int charCnt = Character.charCount(codePoint);
            System.out.printf("%s: %d\n", s.substring(i, i + charCnt), Character.charCount(codePoint));
            i += charCnt;
            ++n;
        }

        return n;
    }
}


