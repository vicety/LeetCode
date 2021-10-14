package com.company.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class P150 {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>();
        operators.addAll(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> numStack = new Stack<>();
        for (String str : tokens) {
            if (operators.contains(str)) {
                int b = numStack.pop();
                int a = numStack.pop();
                switch (str) {
                    case "+":
                        numStack.push(a + b);
                        break;
                    case "-":
                        numStack.push(a - b);
                        break;
                    case "*":
                        numStack.push(a * b);
                        break;
                    default:
                        numStack.push(a / b);
                        break;
                }
            }
            else numStack.push(Integer.valueOf(str));
        }
        return numStack.pop();
    }
}
