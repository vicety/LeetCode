package com.company.leetCode;

public class P223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rectOne = (C - A) * (D - B);
        int rectTwo = (G - E) * (H - F);

        if(A >= G || B >= H || C <= E || D <= F){
            return rectOne + rectTwo;
        }

        int length = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);

        return rectOne + rectTwo - length * height;
    }
}

//    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
//
//        int areaOfSqrA = (C-A) * (D-B);
//        int areaOfSqrB = (G-E) * (H-F);
//
//        int left = Math.max(A, E);
//        int right = Math.min(G, C);
//        int bottom = Math.max(F, B);
//        int top = Math.min(D, H);
//
//        //If overlap
//        int overlap = 0;
//        if(right > left && top > bottom)
//            overlap = (right - left) * (top - bottom);
//
//        return areaOfSqrA + areaOfSqrB - overlap;
//    }