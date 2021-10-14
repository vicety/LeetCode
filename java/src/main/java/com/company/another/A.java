package com.company.another;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

class AAA{
    public static String str = "A";

    static {
        System.out.println(str);
    }
}

class CCCC extends A{
    public static String str2 = "B";

    static {
        System.out.println(str2);
    }
}



public class A{
    public static void main(String[] args) {
        byte a = 12;
        byte b = 116;
        System.out.println((byte) (a + b));
//        ThreadPoolExecutor;
//        Executors.newCachedThreadPool()
//        Future
    }
}

