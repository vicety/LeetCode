package com.company.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

public class ProdCust {

    private final int PROD_NUM = 4;
    private final int CONSUMER_NUM = 4;
    private final int POSITIVE_CONSUMER_NUM = 2;
    private final int NEGATIVE_CONSUMER_NUM = 2;
    // 正常应该封装为一个字段的，这里简化一下
    private final int END_SIGN = 0;

    BlockingQueue<Integer> producerQueue = new LinkedBlockingQueue<>();
    BlockingQueue<Integer> positiveIntQueue = new LinkedBlockingQueue<>();
    BlockingQueue<Integer> negativeIntQueue = new LinkedBlockingQueue<>();
    CountDownLatch remainingProducer = new CountDownLatch(PROD_NUM);
    CountDownLatch remainingConsumer = new CountDownLatch(CONSUMER_NUM);
    Random random = new Random();

    List<Thread> producers = new ArrayList<>();
    List<Thread> consumers = new ArrayList<>();
    List<Thread> positiveConsumers = new ArrayList<>();
    List<Thread> negativeConsumers = new ArrayList<>();

    public void main() {
        Runnable producer = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    int input = random.nextInt();
                    producerQueue.put(input);
                    System.out.println(String.format("%s input %d, produce queue size %d",
                            Thread.currentThread().getName(), input, producerQueue.size()));
                }
                System.out.println(String.format("%s exit", Thread.currentThread().getName()));
                remainingProducer.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread prodEnder = new Thread(() -> {
            try {
                remainingProducer.await();
                for (int i = 0; i < PROD_NUM; i++) {
                    producerQueue.put(END_SIGN);
                }
                System.out.println(String.format("%s exit", Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-Prod-Ender");

        Thread consumerEnder = new Thread(() -> {
            try {
                remainingConsumer.await();
                for (int i = 0; i < POSITIVE_CONSUMER_NUM; i++) {
                    positiveIntQueue.put(END_SIGN);
                }
                for (int i = 0; i < NEGATIVE_CONSUMER_NUM; i++) {
                    negativeIntQueue.put(END_SIGN);
                }
                System.out.println(String.format("%s exit", Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-Consumer-Ender");


        Runnable fetcher = () -> {
            try {
                while (true) {
                    int item = producerQueue.take();
                    System.out.println(String.format("%s got %d", Thread.currentThread().getName(), item));
                    if (item == END_SIGN) break;
                    if (item > 0) positiveIntQueue.put(item);
                    else negativeIntQueue.put(item);
                }
                System.out.println(String.format("%s exit", Thread.currentThread().getName()));
                remainingConsumer.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable positiveConsumer = () -> {
            try {
                while (true) {
                    int num = positiveIntQueue.take();
                    System.out.println(String.format("%s got %d", Thread.currentThread().getName(), num));
                    if (num == END_SIGN) break;
                }
                System.out.println(String.format("%s exit", Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable negativeConsumer = () -> {
            try {
                while (true) {
                    int num = negativeIntQueue.take();
                    System.out.println(String.format("%s got %d", Thread.currentThread().getName(), num));
                    if (num == END_SIGN) break;
                }
                System.out.println(String.format("%s exit", Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        prodEnder.start();
        consumerEnder.start();

        for (int i = 0; i < PROD_NUM; i++) {
            producers.add(new Thread(producer, String.format("Thread-Producer-%s", i)));
            producers.get(i).start();
        }

        for (int i = 0; i < CONSUMER_NUM; i++) {
            consumers.add(new Thread(fetcher, String.format("Thread-Consumer-%s", i)));
            consumers.get(i).start();
        }

        for (int i = 0; i < POSITIVE_CONSUMER_NUM; i++) {
            positiveConsumers.add(new Thread(positiveConsumer, String.format("Thread-Consumer-Positive-%s", i)));
            positiveConsumers.get(i).start();
        }

        for (int i = 0; i < NEGATIVE_CONSUMER_NUM; i++) {
            negativeConsumers.add(new Thread(negativeConsumer, String.format("Thread-Consumer-Negative-%s", i)));
            negativeConsumers.get(i).start();
        }

    }

}
