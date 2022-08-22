package com.company.concurrent;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ali1_1 {
    public static void main(String[] args) throws InterruptedException {
        // 只用volatile，不用cas
        // TODO: 看能否换成AtomicReference
        AtomicReference<Integer> bodyCount = new AtomicReference<>(0);
//        AtomicInteger wheelCount = new AtomicInteger();
        AtomicReference<Integer> wheelCount = new AtomicReference<>(0);
        Integer bodyMax = 10;
        Integer wheelMax = 20;
        ReentrantLock lock = new ReentrantLock();
        Condition hasNewComponent = lock.newCondition();
        Condition bodyCanResume = lock.newCondition();
        Condition wheelCanResume = lock.newCondition();
        ComponentFactory body = new ComponentFactory("body", bodyCount, bodyMax, lock, hasNewComponent, bodyCanResume);
        ComponentFactory wheel = new ComponentFactory("wheel", wheelCount, wheelMax, lock, hasNewComponent, wheelCanResume);
        Consumer factory = new Consumer(bodyCount, bodyMax, wheelCount, wheelMax, lock, hasNewComponent, bodyCanResume, wheelCanResume);

        factory.start();
        body.start();
        wheel.start();

        Thread.sleep(1000);

        factory.interrupt();
        body.interrupt();
        wheel.interrupt();
    }
}

// 零件
class ComponentFactory extends Thread {
    private String componentName;
    private AtomicReference<Integer> componentCnt;
    private Integer componentMax;
    private Lock lock;
    private Condition hasNewComponent;
    private Condition resumeCondition;

    public ComponentFactory(String name, AtomicReference<Integer> cnt, Integer componentMax, Lock lock, Condition hasNewComponent, Condition resumeCondition) {
        this.componentName = name;
        this.componentCnt = cnt;
        this.componentMax = componentMax;
        this.lock = lock;
        this.resumeCondition = resumeCondition;
        this.hasNewComponent = hasNewComponent;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (componentCnt.get() == componentMax) {
                try {
                    System.out.printf("%s sleep because reached max %d\n", componentName, componentMax);
                    resumeCondition.await();
                } catch (InterruptedException e) {
                    System.out.printf("%s interrupted, exit...\n", componentName);
                    lock.unlock();
                    return;
                }
            }

            lock.lock();
            componentCnt.set(componentCnt.get() + 1);
            lock.unlock();

//            componentCnt.getAndIncrement();
            hasNewComponent.signal();
            lock.unlock();
        }

    }
}

// 组装车间
class Consumer extends Thread {
    private AtomicReference<Integer> bodyCount;
    private Integer bodyMax;
    private AtomicReference<Integer> wheelCount;
    private Integer wheelMax;
    private Lock lock;
    private Condition hasNewComponent;
    private Condition bodyCondition;
    private Condition wheelCondition;

    public Consumer(AtomicReference<Integer> bodyCount, Integer bodyMax, AtomicReference<Integer> wheelCount, Integer wheelMax,
                    Lock lock, Condition hasNewComponent, Condition bodyCondition, Condition wheelCondition) {
        this.bodyCount = bodyCount;
        this.bodyMax = bodyMax;
        this.wheelCount = wheelCount;
        this.wheelMax = wheelMax;
        this.lock = lock;
        this.hasNewComponent = hasNewComponent;
        this.bodyCondition = bodyCondition;
        this.wheelCondition = wheelCondition;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            while (wheelCount.get() < 2 || bodyCount.get() < 1) {
                try {
                    System.out.printf("factory sleep because not enough component, current wheel[%d] body[%d]\n", wheelCount.get(), bodyCount.get());
                    hasNewComponent.await();
                } catch (InterruptedException e) {
                    System.out.println("factory interrupted, exit...");
                    lock.unlock();
                    return;
                }
            }

            lock.lock();
            wheelCount.set(wheelCount.get() - 2);
            bodyCount.set(bodyCount.get() - 1);
            lock.unlock();

            System.out.println("produced a new bike");
            if (wheelCount.get() < wheelMax / 2) {
                wheelCondition.signal();
            }
            if (bodyCount.get() < bodyMax / 2) {
                bodyCondition.signal();
            }
            lock.unlock();
        }
    }
}