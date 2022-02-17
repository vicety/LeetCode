package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    private void ff() throws RuntimeException {

    }

    private void gg() throws Exception {

    }

}


// Java program to demonstrate the usage of
// setDaemon() and isDaemon() method.
class DaemonThread extends Thread {
    public DaemonThread(String name) {
        super(name);
    }

    public void run() {
        // Checking whether the thread is Daemon or not
        if (Thread.currentThread().isDaemon()) {
            System.out.println(getName() + " is Daemon thread");
        } else {
            System.out.println(getName() + " is User thread");
        }
    }

    public void test() {
        DaemonThread t1 = new DaemonThread("t1");
        DaemonThread t2 = new DaemonThread("t2");
        DaemonThread t3 = new DaemonThread("t3");

        // Setting user thread t1 to Daemon
        t1.setDaemon(true);

        // starting first 2 threads
        t1.start();
        t2.start();

        // Setting user thread t3 to Daemon
        t3.setDaemon(true);
        t3.start();
    }


    public static void main(String[] args) throws InterruptedException, IOException {
//        A a = new A();
//        a.run();
//        RandomAccessFile randomAccessFile = new RandomAccessFile("./ttt", "rw");
//        randomAccessFile.setLength(0);
//        randomAccessFile.seek(20);
//        randomAccessFile.write('c');
//        System.out.println(randomAccessFile.length());
//        byte[] data = new byte[30];
////        randomAccessFile.readFully(data);
//        randomAccessFile.seek(0);
//        randomAccessFile.read(data, 0, (int) randomAccessFile.length());
//        System.out.println(Arrays.toString(data));

//        Thread.sleep(10000000);

//        CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
//        ExecutorService executorService = Executors.newFixedThreadPool(8);
//        for (int i = 0; i < 8; i++) {
//            int finalI = i;
//            executorService.submit(() -> {
//                while (true) {
//                    System.out.printf("%d %d start\n", System.currentTimeMillis(), finalI);
//                    Thread.sleep((new Random()).nextInt(2000));
//                    try {
//                        cyclicBarrier.await();
//                    } catch (InterruptedException | BrokenBarrierException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            });
//        }

        long st = System.currentTimeMillis();
        double a = 1.1;
        for (int i = 0; i < 40; i++) {
            System.out.println(i);
            for (int j = 0; j < 20000; j++) {
                for (int k = 0; k < 20000; k++) {
                    a *= a;
                }
            }
        }
        System.out.printf("%d\n", System.currentTimeMillis() - st);
    }
}

class A {
    private int a = 0;

    public void run() throws InterruptedException, IOException {
//        CompletableFuture.supplyAsync()/
//        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
//        CompletableFuture.runAsync().thenRun()
//        completableFuture.thenRunAsync()
//        completableFuture.thenRun(() -> {
//            while (a < 4) {
//                System.out.println("x");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        for (int i = 0; i < 100; i++) {
//            a++;
//            Thread.sleep(10);
//        }
//        Thread.sleep(1000);
//        completableFuture.thenRun(() -> {
//            System.out.println("2");
//        });
//        Thread.sleep(2000);

        RandomAccessFile randomAccessFile = null;
        File file = null;
        try {
            file = new File("./tmp-cy");
            System.out.println(file.getAbsolutePath());
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (randomAccessFile == null) {
            return;
        }

        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(randomAccessFile.length());

//        CompletableFuture.runAsync(() -> {
        randomAccessFile.close();
        try {
            Files.move(Paths.get("./tmp-cy"), Paths.get("./tmp-cy-1"), StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
//        System.out.println(file.delete());
        try {
            RandomAccessFile raf = new RandomAccessFile("./tmp-cy-2", "rw");
            Files.move(Paths.get("./tmp-cy-2"), Paths.get("./tmp-cy"), StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        });

        s = in.next();
        randomAccessFile = new RandomAccessFile(file, "rw");
        System.out.println(randomAccessFile.length());

    }
}