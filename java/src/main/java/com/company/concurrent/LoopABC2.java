package com.company.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

// NOTE: using channel
public class LoopABC2 {
    static class Event {
        public int cnt;
        public boolean end;

        public Event(int cnt, boolean end) {
            this.cnt = cnt;
            this.end = end;
        }
    }

    static class Printer extends Thread {
        BlockingQueue<Event> from;
        BlockingQueue<Event> to;

        public Printer(BlockingQueue<Event> from, BlockingQueue<Event> to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            Event ev = null;
            while (true) {
                try {
                    ev = from.take();
                    if (ev.end) {
                        to.put(ev);
                        break;
                    }
                    System.out.println(ev.cnt);
                    if (ev.cnt == 10) {
                        ev.end = true;
                    }
                    to.put(new Event(ev.cnt + 1, ev.end));
                } catch (InterruptedException e) {
                    // will not happen
                    e.printStackTrace();
                }
            }
            System.out.println("exit");
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue<Event> a2b = new LinkedBlockingQueue<>(1);
//        BlockingQueue<Event> b2c = new LinkedBlockingQueue<>(1);
//        BlockingQueue<Event> c2a = new LinkedBlockingQueue<>(1);
//
//        // NOTE: 无缓冲，最后一次会卡住，还是要有一个缓冲
////        BlockingQueue<Event> a2b = new SynchronousQueue<>();
////        BlockingQueue<Event> b2c = new SynchronousQueue<>();
////        BlockingQueue<Event> c2a = new SynchronousQueue<>();
//
//        Printer a = new Printer(c2a, a2b);
//        Printer b = new Printer(a2b, b2c);
//        Printer c = new Printer(b2c, c2a);
//        a.start();
//        b.start();
//        c.start();
//        c2a.put(new Event(1, false));
//        Thread.sleep(1000);

//        System.out.println(char(int('a') + 1));
    }
}
