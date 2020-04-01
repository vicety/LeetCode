package com.company.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class tmp {
    public static tmp t1 = new tmp();
    {
        System.out.print("A");
    }
    static {
        System.out.print('B');
    }

    public static void main(String[] args) {
        tmp t2 = new tmp();
    }
}