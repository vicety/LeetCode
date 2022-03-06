package com.company.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class RWLock {
    class State {
        int readCnt;
        int writeCnt;

        public State(int readCnt, int writeCnt) {
            this.readCnt = readCnt;
            this.writeCnt = writeCnt;
        }
    }

    private State state = new State(0, 0); // 不应当直接访问它，不是volatile的

    //    private AtomicStampedReference<State> stateRef = new AtomicStampedReference<>(state, 0);
    private AtomicReference<State> stateRef = new AtomicReference<>(state);

    public void acquireReadLock() throws InterruptedException {
        while (true) {
            State state = stateRef.get();
            if (state.writeCnt == 0) {
                State newState = new State(state.readCnt + 1, state.writeCnt);
                if (stateRef.compareAndSet(state, newState)) {
                    break;
                }
            }

            synchronized (this) {
                wait();
            }
        }
    }

    public void releaseReadLock() {
        while (true) {
            State state = stateRef.get();
            State newState = new State(state.readCnt - 1, state.writeCnt);
            if (stateRef.compareAndSet(state, newState)) {
                break;
            }
        }

        synchronized (this) {
            notifyAll();
        }
    }

    public void writeLock() throws InterruptedException {
        while (true) {
            State state = stateRef.get();
            if (state.readCnt == 0 && state.writeCnt == 0) {
                State newState = new State(state.readCnt, state.writeCnt + 1);
                if (stateRef.compareAndSet(state, newState)) {
                    break;
                }
            }

            synchronized (this) {
                wait();
            }
        }
    }

    public void releaseWriteLock() {
        State state = stateRef.get();
        State newState = new State(state.readCnt, state.writeCnt - 1);
        stateRef.set(newState);

        synchronized (this) {
            notifyAll();
        }
    }

    public static void main(String[] args) {
        RWLock lock = new RWLock();
        Runnable r = () -> {
            try {
                lock.acquireReadLock();
                System.out.println("read");
                lock.releaseReadLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
