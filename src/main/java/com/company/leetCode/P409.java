package com.company.leetCode;

/**
 * @author vicety
 * @date 2020/4/11 22:06
 */
public class P409 {
    public int longestPalindrome(String s) {
        int[] cnt = new int[256];
        int ans = 0;
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        boolean hasSingle = false;
        for (int i = 0; i < 256; i++) {
            if (!hasSingle && cnt[i] % 2 == 1) {
                hasSingle = true;
                ans++;
            }
            ans += (cnt[i] / 2) * 2;
        }
        return ans;
    }
}
