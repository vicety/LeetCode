package com.company.tmp;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.lang.annotation.RetentionPolicy;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class tmp4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        String aa = "ab"; // 放在常量池中
//        String bb = "ab"; // 从常量池中查找
//        System.out.println(aa == bb);// true
//        System.out.println(aa == new String("ab"));// true
//
//        Number a = new Integer(1);
//        Float b = (Float) a;
//
//        Scanner console=new Scanner(System.in);
//        console.nextLine();
////        CompletableFuture
//        ExecutorService t = Executors.newFixedThreadPool(2);
//        Future f = t.submit();
//
//        CompletableFuture c = CompletableFuture.runAsync(() -> {}, t);
//        c.get();
//        c.thenRun();
//        c.complete()

//        System.out.println("------------- Sleep");
//        CompletableFuture<String> supplyAsyncWithSleep = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "supplyAsyncWithSleep Thread Id : " + Thread.currentThread();
//        });
//        CompletableFuture<String> thenApply = supplyAsyncWithSleep
//                .thenApplyAsync(name -> name + "------thenApply1111 Thread Id : " + Thread.currentThread());
////        Thread.sleep(1500); // 比1000大
////        thenApply = supplyAsyncWithSleep
////                .thenApply(name -> name + "------thenApply2222222 Thread Id : " + Thread.currentThread());
//
//        CompletableFuture<String> thenApplyAsync = supplyAsyncWithSleep
//                .thenApplyAsync(name -> name + "------thenApplyAsync Thread Id : " + Thread.currentThread());
//        System.out.println("Main Thread Id: " + Thread.currentThread());
//        System.out.println(thenApply.get());
//        System.out.println(thenApplyAsync.get());
//
//        System.out.println("------------- No Sleep");
//        CompletableFuture<String> supplyAsyncNoSleep = CompletableFuture.supplyAsync(() -> {
//            return "supplyAsyncNoSleep Thread Id : " + Thread.currentThread();
//        });
//        CompletableFuture<String> thenApplyNoSleep = supplyAsyncNoSleep
//                .thenApply(name -> name + "------thenApply Thread Id : " + Thread.currentThread());
//        CompletableFuture<String> thenApplyAsyncNoSleep = supplyAsyncNoSleep
//                .thenApplyAsync(name -> name + "------thenApplyAsync Thread Id : " + Thread.currentThread());
//        System.out.println("Main Thread Id: " + Thread.currentThread());
//        System.out.println(thenApplyNoSleep.get());
//        System.out.println(thenApplyAsyncNoSleep.get());

//        int[] a = new int[]{1, 2, 3};
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//        System.out.println(threadLocal.get());
//        threadLocal.set("1");
//        threadLocal.remove();
//        IntStream.of(a).boxed().collect(Collectors.toList()).stream().parallel().forEach();

//        HashMap;
//        List<? extends Integer> l = new ArrayList<>();
//        l.get();
//        l.add()
    }
}
//
//
//class E {
//    void speak() {
//        System.out.println("speak");
//    }
//
//    <T> void show(T t) {
//
//    }
//}