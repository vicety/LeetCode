package com.company.another;

public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();

        } catch (Exception e) {
            System.out.println("栈深度stackLength: " + javaVMStackSOF.stackLength);
            System.exit(-1);
        } finally {
            System.out.println("栈深度stackLength: " + javaVMStackSOF.stackLength);
        }
    }
}