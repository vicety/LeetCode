package com.company.leetCode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class P402_2 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        Stack<Integer> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            int val = c - '0';
            if (stack.empty()) stack.add(val);
            else {
                while (!stack.empty() && stack.peek() > val && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.add(val);
            }
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        Iterator<Integer> iterator = stack.iterator();
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (iterator.hasNext()) {
            int now = iterator.next();
            if (now != 0) leadingZero = false;
            if (!leadingZero) sb.append(now);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    private static P402_2 p402 = new P402_2();

    @Test
    public void test() {
        Assert.assertEquals(p402.removeKdigits("1432219", 3), "1219");
        Assert.assertEquals(p402.removeKdigits("10200", 1), "200");
        Assert.assertEquals(p402.removeKdigits("1234567890", 9), "0");
        Assert.assertEquals(p402.removeKdigits("112", 1), "11");
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        List<Integer> list = new ArrayList<>(stack);
        System.out.println(list);
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}
