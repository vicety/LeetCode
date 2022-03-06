package com.company.tmp;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class tmp1 {
    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("./demo.txt");
        out.write("\ud83d\ude00".getBytes(StandardCharsets.UTF_8));
        InputStreamReader in = new InputStreamReader(new FileInputStream("./demo.txt"), StandardCharsets.UTF_8);

        int i = in.read();
        System.out.println(i); // 55357 d83d
        i = in.read();
        System.out.println(i); // 56832 de00
        i = in.read();
        System.out.println(i); // -1
    }
}
