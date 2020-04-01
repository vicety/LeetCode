package com.company.another;

public class MinorGC {
    private static int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] a1, a2, a3, a4;
        a1 = new byte[_1MB / 4];
        System.out.println("after a1");
        a2 = new byte[4 * _1MB];
        System.out.println("after a2");
        a3 = new byte[4 * _1MB];
        System.out.println("after a3");
        a3 = null;
        System.out.println("after a3 null");
        a3 = new byte[4 * _1MB];
        System.out.println("after a3 reDef");
    }
}
