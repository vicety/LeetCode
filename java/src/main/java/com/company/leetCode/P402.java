//package com.company.leetCode;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class P402 {
//    class Node {
//        Node prev, next;
//        int val;
//
//        public Node(Node prev, Node next, int val) {
//            this.prev = prev;
//            this.next = next;
//            this.val = val;
//        }
//    }
//
//    public String removeKdigits(String num, int k) {
//        if (k >= num.length()) return "0";
//        System.out.println(num.length());
//        Node now = null;
//        Node head = null;
//        Node tail = null;
//        for (char c : num.toCharArray()) {
//            if (head == null) {
//                head = new Node(null, null, c - '0');
//                now = head;
//            } else {
//                now.next = new Node(now, null, c - '0');
//                now = now.next;
//            }
//        }
//        tail = now;
//        now = head;
//        System.out.println(tail.val);
//        while (now.next != null && k != 0) {
//            if (now.val > now.next.val) {
//                if (now == head) head = now.next;
//                if (now.prev != null) now.prev.next = now.next;
//                now.next.prev = now.prev;
//                if (now.prev != null) now = now.prev;
//                else now = now.next;
//                k--;
//            } else now = now.next;
//        }
//        now = head;
//        int cnt = 0;
//        while(now != null) {
//            cnt++;
//            now = now.next;
//        }
//        System.out.println(cnt);
//        System.out.println(k);
//        while (k != 0) {
//            if(tail.prev != null) tail.prev.next = null;
//            tail = tail.prev;
//            k--;
//        }
//        StringBuilder ans = new StringBuilder();
//        now = head;
//        boolean leadingZero = true;
//        while (now != null) {
//            if(now.val != 0) leadingZero = false;
//            if(!leadingZero) ans.append(now.val);
//            now = now.next;
//        }
//        return ans.length() == 0 ? "0" : ans.toString();
//    }
//
//
//    private static P402 p402 = new P402();
//
//    @Test
//    public void test() {
//        Assert.assertEquals(p402.removeKdigits("1432219", 3), "1219");
//        Assert.assertEquals(p402.removeKdigits("10200", 1), "200");
//        Assert.assertEquals(p402.removeKdigits("1234567890", 9), "0");
//    }
//
//    public static void main(String[] args) {
//        P402 p402 = new P402();
//        System.out.println(p402.removeKdigits("1432219", 3));
//    }
//}
