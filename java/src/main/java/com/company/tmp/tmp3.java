package com.company.tmp;

public class tmp3 {
    public static void main(String[] args) {

        System.out.println("\ud83d\ude00".length()); // 😀 UTF-16 内码
        System.out.println(tmp3.codePointsLength("\ud83d\ude00"));
    }

    static int codePointsLength(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); ) {
            int codePoint = s.codePointAt(i);
            int charCnt = Character.charCount(codePoint);
            System.out.printf("%s: %d\n", s.substring(i, i + charCnt), Character.charCount(codePoint));
            i += charCnt;
            ++n;
        }

        return n;
    }
}

//class Q {
//    Integer f() {
//        return 1;
//    }
//}
//
//class W extends Q {
//    Double f() {
//
//        return 0.0;
//    }
//}