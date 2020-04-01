package com.company.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P299 {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] cnt = new int[256];
        int[] mask = new int[secret.length()];
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
                mask[i] = 1;
            } else cnt[secret.charAt(i)]++;

        }
        for (int i = 0; i < guess.length(); i++) {
            if (mask[i] == 1) continue;
            char c = guess.charAt(i);
            if (cnt[c] != 0) {
                cnt[c]--;
                b++;
            }
        }

        return String.format("%dA%dB", a, b);
    }

    public static void main(String[] args) {
        P299 p229 = new P299();
        System.out.println(p229.getHint("1807", "7810"));
    }
}
