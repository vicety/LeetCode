package com.company.leetCode;

public class P9 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(-121));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return true;
    }
}
