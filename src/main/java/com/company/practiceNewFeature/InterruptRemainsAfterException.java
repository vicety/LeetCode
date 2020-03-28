package com.company.practiceNewFeature;

// 检查是否interrupt被catch后会设为false，答案是会
public class InterruptRemainsAfterException {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                System.out.println(Thread.interrupted());
            }
        });
        t.start();
        t.interrupt();
    }
}
