//package com.interview.wangyihuyu;
//
//import com.company.another.A;
//
//import java.io.*;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class P3 {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        sc.nextLine();
//        for (int tt = 0; tt < t; tt++) {
//            StringBuilder s = new StringBuilder();
//            for (int i = 0; i < 3; i++) {
//                s.append(sc.nextLine());
//            }
//            String s1 = s.toString();
//            boolean[] valid = new boolean[9];
//            for (int ii = 0; ii < 9; ii++) {
//                if (s1.charAt(ii) == '.') {
//                    valid[ii] = true;
//                }
//            }
////            FileInputStream var1 = new FileInputStream(new File("test1"));
////            InputStreamReader;
////            FileReader
//        }
//    }
//
//    // h: sti stj edi edj
//    // sort by ijxie
//
//    private static void dfs(int now, boolean[] valid, Set<String> vislineset, List<String> vislinelst, Set<Integer> path, Set<String> all) {
//        int nowi = now / 3;
//        int nowj = now % 3;
//        String encodedCur = toStr(vislinelst);
//        all.add(encodedCur);
//        for (int i = 0; i < 9; i++) {
//            if (valid[i] && i != now && !path.contains(i)) {
//                int dsti = i / 3;
//                int dstj = i % 3;
//                String encodeLine = encodeLine(nowi, nowj, dsti, dstj);
//                String stash = null;
//                if (encodeLine.equals("0011") && vislineset.contains(""))
//
//                path.add(now);
////                dfs(i, valid, )
//                path.remove(now);
//            }
//        }
//    }
//
//    private static String encodeLine(int i1, int j1, int i2, int j2) {
//        int tmpi, tmpj;
//        if (i1 > i2 || (i1 == i2 && j1 > j2)) {
//            tmpi = i1;
//            tmpj = j1;
//            i1 = i2;
//            j1 = j2;
//            i2 = tmpi;
//            j2 = tmpj;
//        }
////        int deltaY = j2 - j1;
////        int deltaX = i2 - i1;
////        String xie;
////        if (j2 == j1) {
////            xie = "0";
////        } else if (i2 == i1) {
////            xie = "9";
////        } else {
////            if (Math.abs(deltaY) == Math.abs(deltaX)) {
////                if (deltaY == -deltaX) xie = "-1";
////                else xie = "1";
////            } else {
////                xie = String.format("%d-%d", deltaY, deltaX);
////            }
////        }
////        return String.format("%d%d%d%d", i1, j1, i2, j2)
////    }
//
//    private static String toStr(List<String> visLineLst) {
//        List<String> cp = new ArrayList<>(visLineLst);
//        cp.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                // -1 o1 < o2
//                for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
//                    if (o1.charAt(i) > o2.charAt(i)) {
//                        return 1;
//                    } else if (o1.charAt(i) < o2.charAt(i)) {
//                        return -1;
//                    }
//                }
//
//                if (o1.length() > o2.length()) {
//                    return 1;
//                }
//                return -1;
//            }
//        });
//        StringBuilder sb = new StringBuilder();
//        for (String s : cp) {
//            sb.append(s);
//        }
//        return sb.toString();
//    }
//
//}
