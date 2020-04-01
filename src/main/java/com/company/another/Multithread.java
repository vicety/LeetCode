package com.company.another;

import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Multithread {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
//        Thread.State
        Thread A = new Thread(() -> {
            try {
                System.out.println("A Start " + simpleDateFormat.format(new Date()));
                Thread.sleep(1000);
                System.out.println("A finish " + simpleDateFormat.format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            System.out.println("B " + simpleDateFormat.format(new Date()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B finish " + simpleDateFormat.format(new Date()));
        });
        A.start();
        B.start();
        B.join();
        System.out.println(Reflection.getCallerClass(1));
        Unsafe.getUnsafe();
        System.out.println("here " + simpleDateFormat.format(new Date()));
    }
}
