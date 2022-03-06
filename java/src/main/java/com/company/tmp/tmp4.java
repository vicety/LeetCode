package com.company.tmp;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class tmp4 {
    public static void main(String[] args) {
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        System.out.println(aa == bb);// true
        System.out.println(aa == new String("ab"));// true

        Number a = new Integer(1);
        Float b = (Float) a;

        Scanner console=new Scanner(System.in);
        console.nextLine()
    }
}
//
//
//class E {
//    void speak() {
//        System.out.println("speak");
//    }
//
//    <T> void show(T t) {
//
//    }
//}