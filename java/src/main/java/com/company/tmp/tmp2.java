package com.company.tmp;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class tmp2 {
    public static void main(String[] args) {
//        byte[] bytes = "à".getBytes(StandardCharsets.UTF_8);
//        byte[] bytes = "\uD842\uDFB7".getBytes(StandardCharsets.UTF_8);
//        StringBuilder sb = new StringBuilder();
//        for (byte b : bytes) {
//            sb.append(String.format("%02X ", b));
//        }
//        System.out.println(sb);
        System.out.println("Default Charset=" + Charset.defaultCharset());
    }

}
