//package com.company.leetCode;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.Stack;
//
///**
// * @author vicety
// * @date 2020/4/10 2:28
// */
//public class P405 {
//    public String toHex(int num) {
//        if (num == 0) return "0";
//        StringBuilder sb = new StringBuilder();
//        sb.append(byteToHex((num & 0xff000000) >>> 24));
//        sb.append(byteToHex((num & 0x00ff0000) >>> 16));
//        sb.append(byteToHex((num & 0x0000ff00) >>> 8));
//        sb.append(byteToHex((num & 0x000000ff)));
//        String ans = sb.toString();
//        for (int i = 0; i < ans.length(); i++) if (ans.charAt(i) != '0') return ans.substring(i);
//        return "-1";
//    }
//
//    private String byteToHex(int i) {
//        return String.valueOf(fourBitToHex((i & 0xf0) >> 4)) + fourBitToHex((i & 0x0f));
//    }
//
//    private char fourBitToHex(int i) {
//        if (i < 10) return (char) ('0' + i);
//        else return (char) ('a' + i - 10);
//    }
//
//    private static P405 p405 = new P405();
//
//    @Test
//    private void test1() {
//        Assert.assertEquals(p405.toHex(26), "1a");
//    }
//
//    @Test
//    public void test2() {
//        Assert.assertEquals(p405.toHex(-1), "ffffffff");
//    }
//}
