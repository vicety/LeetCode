//package com.interview.wangyihuyu;
//
//import java.util.*;
//
//public class P2_1 {
//    static class Rec {
//        int i1;
//        int j1;
//        int i2;
//        int j2;
//
//        public Rec(int i1, int j1, int i2, int j2) {
//            this.i1 = i1;
//            this.j1 = j1;
//            this.i2 = i2;
//            this.j2 = j2;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int tt = 0; tt < t; tt++) {
//            int n = sc.nextInt();
//            sc.nextLine();
//            List<Rec> recs = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                String line = sc.nextLine();
//                String[] seg = line.split(" ");
//
//                recs.add(new Rec(Integer.parseInt(seg[0]),
//                        Integer.parseInt(seg[1]),
//                        Integer.parseInt(seg[2]),
//                        Integer.parseInt(seg[3])));
//            }
//
//
//            Set<Rec> vis = new HashSet<>();
//
//            System.out.println(ans);
//        }
//    }
//}
