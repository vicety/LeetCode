package com.company.another;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

abstract class C {
    void f() {
        System.out.println("x");
        int a = 1;
    }

    public int a = 1;

    C() {
        System.out.println("A");
    }
}

class XXXX extends C{
    XXXX() {
        a = 2;
//        Thread
    }
}

interface B {
    int b = 1;
    public static void main(String[] args) {
    }

}
