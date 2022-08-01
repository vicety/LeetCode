package com.company.concurrent;

import java.util.concurrent.CompletableFuture;

public class MethodSync {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        CompletableFuture.runAsync(a::a);
        CompletableFuture.runAsync(a::b);
        Thread.sleep(5000);
    }
}

class A {
    public synchronized void a() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a end");
    }

    public synchronized void b() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b end");
    }
}