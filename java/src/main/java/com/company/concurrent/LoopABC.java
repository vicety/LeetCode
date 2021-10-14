package com.company.concurrent;

import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoopABC {
    private final int timesToPrint = 15;

    Lock lock = new ReentrantLock();
    Condition a2bCondition = lock.newCondition();
    Condition b2cCondition = lock.newCondition();
    Condition c2aCondition = lock.newCondition();
    AtomicInteger cnt = new AtomicInteger(); // 没有线程竞争，其实没必要用原子变量
//    new Thread
//    Class
{
//    Proxy.newProxyInstance()
}

    Thread a, b, c;

    LoopABC() {
        a = new Thread(() -> {
            while (true) {
                if (Thread.interrupted()) break;
                if (cnt.get() == timesToPrint) {
                    b.interrupt();
                    c.interrupt();
                    break;
                }
                lock.lock();
                while (true) {
                    if (cnt.get() % 3 == 0) {
                        System.out.print('a');
                        cnt.getAndIncrement();
                        a2bCondition.signal();
                        break;
                    }
                    else {
                        try {
                            c2aCondition.await();
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            }
        });

        b = new Thread(() -> {
            while (true) {
                if (Thread.interrupted()) break;
                if (cnt.get() == timesToPrint) {
                    a.interrupt();
                    c.interrupt();
                    break;
                }
                lock.lock();
                while (true) {
                    if (cnt.get() % 3 == 1) {
                        System.out.print('b');
                        cnt.getAndIncrement();
                        b2cCondition.signal();
                        break;
                    }
                    else {
                        try {
                            a2bCondition.await();
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            }
        });

        c = new Thread(() -> {
            while (true) {
                if (Thread.interrupted()) break;
                if (cnt.get() == timesToPrint) {
                    a.interrupt();
                    b.interrupt();
                    break;
                }
                lock.lock();
                while (true) {
                    if (cnt.get() % 3 == 2) {
                        System.out.print('c');
                        cnt.getAndIncrement();
                        c2aCondition.signal();
                        break;
                    }
                    else {
                        try {
                            b2cCondition.await();
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        LoopABC loopABC = new LoopABC();
        loopABC.a.start();
        loopABC.b.start();
        loopABC.c.start();
    }
}


