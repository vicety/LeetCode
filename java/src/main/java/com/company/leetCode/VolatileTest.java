package com.company.leetCode;

public class VolatileTest {
    public volatile boolean stop = false;

    public void run() {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                int tmp = 0;
                while(!stop) {
                    System.out.println(String.format("%d", tmp));
                    tmp++;
                    if(tmp == 10) stop = true;
                }
            });
            threads[i].start();
        }
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.run();
        System.out.println("here");
    }
}
