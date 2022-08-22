package com.company.another;


import java.lang.instrument.Instrumentation;
import java.lang.invoke.MethodHandle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodOOM {
//
//    public static int m_member;
//    public static double m_static_member;
//    protected Useless m_useless;
//
//
//    private void test() {
//        Useless useless = new Useless();
//        System.out.println(useless.useless_c);
//        WeakReference<Useless> wr = new WeakReference<>(useless);
//    }
//
//    public static void main(String[] args) {
//        List<String> ls = new ArrayList<>();
//        int i = 0;
//        System.out.println(Useless.a);
//        while (true) {
//            ls.add(String.valueOf(i++).intern());
//        }
//    }
}

interface testInterface {
    int m_member = 1;
//    Instrumentation
}

class Something extends MethodOOM implements testInterface {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
