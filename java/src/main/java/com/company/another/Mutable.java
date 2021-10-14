package com.company.another;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Mutable {
    private final String name;
    private final int age;
    private final Date birthday;

    /**
     * 构造方法
     * @param name
     * @param age
     */
    public Mutable(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    /**
     * 去除所有的setter方法
     */
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    /**
     * 将年龄增加10岁
     * @param newAge
     * @return
     */
    public Mutable addAge(int newAge) {
        /**
         * 重新返回一个对象
         */
        return new Mutable(this.getName(), newAge + this.getAge(), this.birthday);
    }

    public static void main(String[] args) {
        Date birthday = new Date();
        Mutable xiaoming = new Mutable("小明", 21, birthday);
        System.err.println("小明的生日为 ： " + xiaoming.getBirthday());

        //我设置下我的生日，你会发现我的生日居然可以改变
        birthday.setTime(System.currentTimeMillis() + 1000000000);
        System.err.println("小明的生日为 ： " + xiaoming.getBirthday());
    }


}
