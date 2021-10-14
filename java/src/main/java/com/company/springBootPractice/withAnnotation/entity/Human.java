package com.company.springBootPractice.withAnnotation.entity;

/**
 * @author vicety
 * @date 2020/4/13 11:18
 */
public class Human {
    private int hp;
    private String name;

    public Human(int hp, String name) {
        this.hp = hp;
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
