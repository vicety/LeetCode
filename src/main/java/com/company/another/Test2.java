package com.company.another;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class Test19122901 {

    final int a;
    {
        a = 1;
        System.out.println("xx");
    }
    int c = f();
    Test19122901() {
        System.out.println("Test19122901");
//        ReentrantLock;
//        HashMap;
//        StringBuilder;
//        StringBuffer;
//        Thread.State;
//        Thread.sleep();
//        String;
//        HashMap
    }

    {
        System.out.println("yy");
    }

    private int f() {
        System.out.println("here");
        return 1;
    }
}

public class Test2{
    public static void main(String[] args) {
        Test19122901 test19122901 = new Test19122901();
    }
}

