package com.company.concurrent;

import java.lang.reflect.Proxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoopABC1 {
    private final int timesToPrint = 123;

    Lock lock = new ReentrantLock();
    Condition a2bCondition = lock.newCondition();
    Condition b2cCondition = lock.newCondition();
    Condition c2aCondition = lock.newCondition();
    AtomicInteger cnt = new AtomicInteger(); // 没有线程竞争，其实没必要用原子变量，但是我们需要一个容器包装Integer

    PrintThread a, b, c;

    LoopABC1() {
        a = new PrintThread("a", c2aCondition, a2bCondition);
        b = new PrintThread("b", a2bCondition, b2cCondition);
        c = new PrintThread("c", b2cCondition, c2aCondition);
        a.setBefore(c);
        a.setAfter(b);
        b.setBefore(a);
        b.setAfter(c);
        c.setBefore(b);
        c.setAfter(a);
    }

    class PrintThread extends Thread {
        String name;
        Condition beforeCond, afterCond;
        PrintThread before, after;

        public void setBefore(PrintThread before) {
            this.before = before;
        }

        public void setAfter(PrintThread after) {
            this.after = after;
        }

        PrintThread(String name, Condition beforeCond, Condition afterCond) {
            this.name = name;
            this.beforeCond = beforeCond;
            this.afterCond = afterCond;
        }

        @Override
        public void run() {
            int n;
            lock.lock();
            // NOTE: 错误的设计！这里可能会
            while (true) {
                if (cnt.get() == timesToPrint) {
                    before.interrupt();
                    after.interrupt();
                    System.out.printf("%s exit, interrupt %s %s\n", name, before.name, after.name);
                    lock.unlock();
                    break;
                }

                n = cnt.get() % 3;
                System.out.printf("%s: %s\n", name, (char) ((int) 'a' + n));
                cnt.getAndIncrement();
                try {
                    afterCond.signal();
                    System.out.printf("%s await, signal %s\n", name, after.name);
                    beforeCond.await();
                } catch (InterruptedException e) {
                    // NOTE: 注意任何方式退出都会拿到锁
                    System.out.printf("%s interrupted, exit\n", name);
                    lock.unlock();
                    break;
                }
                System.out.printf("%s await returns\n", name);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LoopABC1 loopABC = new LoopABC1();
        loopABC.a.start();
        loopABC.b.start();
        loopABC.c.start();
        Thread.sleep(500);
    }
}


// NOTE：这个例子有问题，麻了
//b: a
//b await, signal c
//a: b
//a await, signal b
//c: c
//c await, signal a
//b await returns
//b: a
//b await, signal c
//a await returns
//a: b
//a await, signal b
//c await returns
