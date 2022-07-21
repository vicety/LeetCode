package com.company.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// TODO: 看下用CAS能否实现

public class ProdConsumeWaitNotify {
    public static void main(String[] args) {
        Random random = new Random();

        Queue q = new Queue();
        for (int j = 0; j < 2; j++) {
            CompletableFuture.runAsync(() -> {
                for (int i = 0; i < 500; i++) {
                    try {
                        q.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (random.nextInt(20) == 0) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        List<CompletableFuture<Void>> l = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int finalI = i;
            l.add(CompletableFuture.runAsync(() -> {
                for (int j = 0; j < 500; j++) {
                    try {
                        System.out.println(finalI + " " + q.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (random.nextInt(20) == 0) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }));
        }

        for (CompletableFuture<Void> completableFuture : l) {
            try {
                completableFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
//        ArrayBlockingQueue
    }
}

class Queue {
    private int capacity = 10;
    private int[] data = new int[capacity];
    private int st = 0; // queue tail, exclusive
    private int ed = 0; // head, exclusive, (move right, then get)
    private int sz = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public int get() throws InterruptedException {
        lock.lock();
        while (sz == 0) {
            notEmpty.await();
        }
        ed = (ed + 1) % capacity;
        sz -= 1;
        int result = data[ed];
        notFull.signal();
        lock.unlock();

        return result;
    }

    public void put(int val) throws InterruptedException {
        lock.lock();
        while (sz == capacity) {
            notFull.await();
        }
        st = (st + 1) % capacity;
        sz += 1;
        data[st] = val;
        notEmpty.signal();
        lock.unlock();
    }
}