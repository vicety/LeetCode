package com.company.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class TestVolatile {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (!flag) {
            }
            System.out.println("此时可见");
        });
        a.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread b = new Thread(() -> {
            flag = true;
        });
        b.start();
        ReentrantLock e;
//        e.lockInterruptibly();
    }
}

