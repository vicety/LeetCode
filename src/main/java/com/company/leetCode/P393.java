package com.company.leetCode;

public class P393 {
    public boolean validUtf8(int[] data) {
        int cnt = 0;
        for (int byt : data) {
            String str = getBitSeq(byt);
            if (str.startsWith("110")) cnt = 1;
            else if (str.startsWith("1110")) cnt = 2;
            else if (str.startsWith("11110")) cnt = 3;
            else {
                if(cnt == 0 && !str.startsWith("0")) return false;
                else {
                    if(!str.startsWith("10")) return false;
                    cnt--;
                }
            }
        }
        return true;
    }

    private String getBitSeq(int byt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            sb.append((byt >> i) & 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(1 >> 0);
    }
}
