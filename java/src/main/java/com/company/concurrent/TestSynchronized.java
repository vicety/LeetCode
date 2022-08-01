package com.company.concurrent;

public class TestSynchronized {
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (true) {
                synchronized (TestSynchronized.class) {
                    if (flag) {
                        break;
                    }
                }
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
            synchronized (TestSynchronized.class) {
                flag = true;
            }
        });
        b.start();
    }
}
