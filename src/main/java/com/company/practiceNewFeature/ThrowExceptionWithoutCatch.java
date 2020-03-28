package com.company.practiceNewFeature;

public class ThrowExceptionWithoutCatch {
    public static void main(String[] args) {
        try {
            System.out.println("here");
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("there");
        }

        throw new RuntimeException();
//        throw new Error();


    }
}
