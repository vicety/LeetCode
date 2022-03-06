package com.company.tmp;

import java.util.Objects;

public class tmp {
//    public static tmp t1 = new tmp();
//    {
//        System.out.print("A");
//    }
//    static {
//        System.out.print('B');
//    }

    public static void main(String[] args) {
        A a = new B();
        C c = (C) a;
    }
}

class B extends A {
    void a() {
//        AbstractQueuedSynchronizer
//        (new String("xx")).codePointAt()
    }

}

class C extends A {

}

class A {
    int a;
    int b;
    String c;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a1 = (A) o;
        return a == a1.a && b == a1.b && Objects.equals(c, a1.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}