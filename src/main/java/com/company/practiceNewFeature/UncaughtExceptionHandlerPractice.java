package com.company.practiceNewFeature;

public class UncaughtExceptionHandlerPractice {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                throw new RuntimeException("abc");
            } finally {
                System.out.println("finally");
            }

        });
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(e.getMessage());
        });
        System.out.println("x");
        thread.start();
        Thread.sleep(2000);
        System.out.println(thread.isAlive());
        System.out.println("x");

    }
}
