package com.company.practiceNewFeature;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class FuturePractice {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long l = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> {
            System.out.println("执行耗时操作");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行结果就绪");
            return 100;
        });
//        executorService.execute();
//        LinkedBlockingQueue

        mainThreadTasks();
        System.out.println("到达阻塞点");
        System.out.println(String.format("future执行结果为：%d", future.get()));
        System.out.println(String.format("执行时间：%d", System.currentTimeMillis() - l));
//        ReentrantLock
    }

    private static void mainThreadTasks() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println(String.format("主线程完成任务-%d", i));
        }
    }
}
