package com.company.another;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

enum SomeEnum{
    A, B, C
}

public class TestSyn {

    public int num;

    public synchronized void fun() {
        num++;
    }

    TestSyn() {
        num = 0;
        int a = 234;
    }

}
