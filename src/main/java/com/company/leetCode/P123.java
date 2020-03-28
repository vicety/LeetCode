package com.company.leetCode;

public class P123 {
    public int maxProfit(int[] prices) {
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int nowAns = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else nowAns = Math.max(nowAns, prices[i] - min);
            left[i] = nowAns;
        }
        nowAns = 0;
        int max = Integer.MIN_VALUE;
        for(int i = prices.length - 1; i >= 0; i--) {
            if(prices[i] > max) max = prices[i];
            else nowAns = Math.max(nowAns, max - prices[i]);
            right[i] = nowAns;
        }
        int ans = 0;
        for(int mid = 0; mid < prices.length; mid++) {
            ans = Math.max(ans, left[mid] + right[mid]);
        }
        return ans;
    }

//    public int maxProfit(int[] prices) {
//        int[] leftMin = new int[prices.length];
//        int[] rightMax = new int[prices.length];
//        int[][] dpLeft = new int[prices.length][2];
//        int[] dpRight = new int[prices.length];
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < min) min = prices[i];
//            leftMin[i] = min;
//        }
//        int max = Integer.MIN_VALUE;
//        for (int i = prices.length - 1; i >= 0; i--) {
//            if (prices[i] > max) max = prices[i];
//            rightMax[i] = max;
//        }
//        int tmp = 0;
//        for (int i = 0; i < prices.length; i++) {
//            tmp = Math.max(tmp, prices[i] - leftMin[i]);
//            dpLeft[i][1] = tmp;
//        }
//        tmp = 0;
//        for (int i = prices.length - 1; i >= 0; i--) {
//            tmp = Math.max(tmp, rightMax[i] - prices[i]);
//            dpRight[i] = tmp;
//        }
//        for (int k = 2; k <= 2; k++) {
//            for (int sep = 0; sep < prices.length; sep++) {
//                dpLeft[sep][k] = Math.max(dpLeft[sep][k - 1], dpLeft[sep][k - 1])
//            }
//        }
//    }

    public static void main(String[] args) {
        P123 p123 = new P123();
        System.out.println(p123.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
