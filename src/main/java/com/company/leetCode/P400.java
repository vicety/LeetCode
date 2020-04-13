package com.company.leetCode;

public class P400 {
    public int findNthDigit(int n) {
        long[] limit = new long[20];
        long[] begin = new long[20];
        int now = 0;
        int beginNow = 1;
        limit[now++] = 0;
        begin[0] = 1;
        long add = 9;
        int x = 1;
        while (limit[now - 1] <= Integer.MAX_VALUE) {
            limit[now] = limit[now++ - 1] + add * x;
            begin[beginNow] = begin[beginNow++ - 1] * 10;
            add *= 10;
            x++;
        }
        for (int i = 1; i <= 20; i++) {
            if (n > limit[i - 1] && n <= limit[i]) {
                long num = n - limit[i - 1] - 1;
                long pass = num / i;
                String theNumber = String.valueOf(begin[i - 1] + pass);
                int nth = (int) num % i;
                return Integer.parseInt(String.valueOf(theNumber.charAt(nth)));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P400 p400 = new P400();
        System.out.println(p400.findNthDigit(1999));
    }
}
