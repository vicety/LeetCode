package com.company.leetCode;

public class P275 {
    public int hIndex(int[] citations) {
        int l = 1, r = citations.length;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (citations[citations.length - mid] == mid) return mid;
            else if (citations[citations.length - mid] > mid) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        P275 p275 = new P275();
        System.out.println(p275.hIndex(new int[]{100}));
    }
}
