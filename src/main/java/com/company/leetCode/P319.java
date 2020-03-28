package com.company.leetCode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P319 {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        P319 p319 = new P319();
        System.out.println(p319.bulbSwitch(20));
    }
}
