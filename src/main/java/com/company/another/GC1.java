package com.company.another;

import sun.misc.Lock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class GC1 {
    final static int _1M = 1024 * 1024;

    private byte[] xx = new byte[2 * _1M];

    public GC1 ref = null;

    public int f() {
        int a = 10;
        try {
            a += 10;
            return a += 20;
        } finally {
            a += 30;
            System.out.println(a);
            return a;
        }
    }

    public static void main(String[] args) {
        String a = "123";
        String b= "123";
        System.out.println(a == b);
//        Lock;
//        java.util.concurrent.locks.Lock lock = new ReentrantLock();
//        ThreadLocal;
//        LinkedList;
//        ArrayList
        AtomicInteger aa = new AtomicInteger();
        aa.addAndGet(1);
    }

}
