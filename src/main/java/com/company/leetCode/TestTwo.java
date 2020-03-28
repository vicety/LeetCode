package com.company.leetCode;

public class TestTwo {
    public volatile int volI;

    public void inc() {
        volI += 1;
    }

    public static void main(String[] args) {
        Object object = new Object();
//        object.f(); // 尽管IDE不能发现f方法，但是编译时能过的，运行时报错
//        Exception in thread "main" java.lang.NoSuchMethodError: java.lang.Object.f()V
//        at com.company.com.leetCode.TestTwo.main(TestTwo.java:12)
    }
}

