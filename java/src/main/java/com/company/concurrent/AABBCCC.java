package com.company.concurrent;

//评测题目: 有3个线程，一个线程负责输出A，一个线程负责输出B，一个线程负责输出C。
//请设计一个代码，向一个文件中写入AABBCCCAABBCCC循环下去。

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AABBCCC {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Event> aToB = new LinkedBlockingQueue();
        BlockingQueue<Event> bToC = new LinkedBlockingQueue();
        BlockingQueue<Event> cToA = new LinkedBlockingQueue();
        Printer a = new Printer(cToA, aToB, "AA");
        Printer b = new Printer(aToB, bToC, "BB");
        Printer c = new Printer(bToC, cToA, "CCC");

        a.start();
        b.start();
        c.start();

        cToA.put(new Event(0));
        Thread.sleep(1000);
    }

}

class Event {
    public int cnt;

    public Event(int cnt) {
        this.cnt = cnt;
    }
}

class Printer extends Thread {
    BlockingQueue<Event> from;
    BlockingQueue<Event> to;
    String str;

    public Printer(BlockingQueue<Event> from, BlockingQueue<Event> to, String str) {
        this.from = from;
        this.to = to;
        this.str = str;
    }

    public void run() {
        while (true) {
            Event ev;
            try {
                ev = from.take();
                System.out.println(this.str);
                to.put(new Event(-1));
            } catch (Exception e) {
                // interrupted
                break;
            }
        }
    }
}

// 设备接入 20 人

// 数据分析
// 工程方向 45个 人
// 关联查询 sql，离线分析，
// 流式 实时管道
// 算法能力 时序数据的算法

// 多少人
// 10 - 7、8
// 主管 HR