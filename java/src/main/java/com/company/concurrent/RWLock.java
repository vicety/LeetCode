package com.company.concurrent;

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

    private volatile State state = new State(0, 0);

    private AtomicStampedReference<State> stateRef = new AtomicStampedReference<>(state, 0);

    public void acquireReadLock() throws InterruptedException {
        while (true) {
            int[] tsHolder = new int[1];
            State state = stateRef.get(tsHolder);
            if (state.writeCnt == 0) {
                State newState = new State(state.readCnt + 1, state.writeCnt);
                if (stateRef.compareAndSet(state, newState, tsHolder[0], tsHolder[0] + 1)) {
                    break;
                }
            }

            synchronized (this) {
                wait();
                // 锁内，不会并发修改
                if (stateRef.getReference().writeCnt == 0) {
                    State newState = new State(stateRef.getReference().readCnt + 1, stateRef.getReference().writeCnt);
                    stateRef.set(newState, stateRef.getStamp() + 1);
                    break;
                }
            }
        }
    }

    public void releaseReadLock() {
        while (true) {
            int[] tsHolder = new int[1];
            State state = stateRef.get(tsHolder);
            State newState = new State(state.readCnt - 1, state.writeCnt);
            if (stateRef.compareAndSet(state, newState, tsHolder[0], tsHolder[0] + 1)) {
                break;
            }
        }

        synchronized (this) {
            notifyAll();
        }
    }

    public void writeLock() throws InterruptedException {
        while (true) {
            int[] tsHolder = new int[1];
            State state = stateRef.get(tsHolder);
            if (state.readCnt == 0 && state.writeCnt == 0) {
                State newState = new State(state.readCnt, state.writeCnt + 1);
                if (stateRef.compareAndSet(state, newState, tsHolder[0], tsHolder[0] + 1)) {
                    break;
                }
            }

            synchronized (this) {
                wait();
                // 持有锁，无并发修改
                if (stateRef.getReference().readCnt == 0 && stateRef.getReference().writeCnt == 0) {
                    State newState = new State(stateRef.getReference().readCnt, stateRef.getReference().writeCnt + 1);
                    stateRef.set(newState, stateRef.getStamp() + 1);
                    break;
                }
            }
        }
    }

    public void releaseWriteLock() {
        int[] tsHolder = new int[1];
        State state = stateRef.get(tsHolder);
        State newState = new State(state.readCnt, state.writeCnt - 1);
        stateRef.set(newState, tsHolder[0] + 1);

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
