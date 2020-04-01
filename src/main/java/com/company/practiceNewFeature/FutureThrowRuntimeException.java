package com.company.practiceNewFeature;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureThrowRuntimeException {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Object> future = executorService.submit(() -> {
            throw new Error();
        });
        System.out.print("x");
        Object o = future.get();
    }
}
