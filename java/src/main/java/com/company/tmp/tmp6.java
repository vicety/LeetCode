package com.company.tmp;

import java.util.concurrent.ForkJoinPool;

public class tmp6 {
    static {
        System.out.println("xxx");
    }

    public static void main(String[] args) {
        ForkJoinPool p = ForkJoinPool.commonPool();
//        ForkJoinPool.ManagedBlocker
    }
}
