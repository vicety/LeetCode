package com.interview.wangyihuyu;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
//            System.out.println(n);
//            System.out.println(m);
            char[][] pattern = new char[n][n];
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
//                System.out.println(line);
//                System.out.println(line.length());
                for (int k = 0; k < line.length(); k++) {
                    pattern[i][k] = line.charAt(k);
                }
            }

            int full = 0, half = 0;
            for (half = 0; half < 200; half++) {
                if ((m - half * 2) % n == 0) {
                    full = (m - half * 2) / n;
                    break;
                }
            }

//            System.out.printf("%d %d\n", full, half);

            char[][] dst = new char[m][m];
            for (int i = 0; i < full + 2; i++) {
                for (int j = 0; j < full + 2; j++) {
                    int starti, startj;
                    if (i == 0) {
                        starti = 0;
                    } else {
                        starti = half + (i - 1) * n;
                    }

                    if (j == 0) {
                        startj = 0;
                    } else {
                        startj = half + (j - 1) * n;
                    }

                    int ioffset, joffset, isz, jsz;

                    if (i == 0) {
                        ioffset = n - half;
                        isz = half;
                    } else if (i == full + 1) {
                        ioffset = 0;
                        isz = half;
                    } else {
                        ioffset = 0;
                        isz = n;
                    }

                    if (j == 0) {
                        joffset = n - half;
                        jsz = half;
                    } else if (j == full + 1) {
                        joffset = 0;
                        jsz = half;
                    } else {
                        joffset = 0;
                        jsz = n;
                    }


                    for (int locali = 0; locali < isz; locali++) {
                        for (int localj = 0; localj < jsz; localj++) {
                            dst[locali + starti][localj + startj] = pattern[ioffset + locali][joffset + localj];
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(dst[i][j]);
                }
//                sb.append("\n");
                System.out.println(sb.toString());
            }

            System.out.println();

            if (tt != t - 1) {
                sc.nextLine();
            }
        }

    }
}

//1
//3 5
//1x1
//xox
//1x1

//1
//3 7
//1x1
//xox
//1x1

//3
//3 5
//1x1
//xox
//1x1
//
//3 7
//1x1
//xox
//1x1
//
//5 7
//13S31
//LKcKL
//Sc2cS
//LKcKL
//13S31