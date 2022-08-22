//package com.company.leetCode;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.*;
//
///**
// * @author vicety
// * @date 2020/4/11 16:58
// */
//public class P406 {
//
//
//    public int[][] reconstructQueue(int[][] people) {
//        Set<Integer> stat = new HashSet<>();
//        Map<Integer, Integer> toIndex = new HashMap<>();
//        for (int i = 0; i < people.length; i++) {
//            int val = people[i][0];
//            stat.add(val);
//        }
//        int[] bit = new int[stat.size() + 1];
//        List<Integer> sortedList = (new ArrayList<>(stat));
//        sortedList.sort(Comparator.comparingInt(i -> -i));
//        for (int i = 0; i < sortedList.size(); i++) {
//            toIndex.put(sortedList.get(i), i + 1);
//        }
//        int[][] ans = new int[people.length][2];
//        int[] vis = new int[people.length];
//        for (int i = 0; i < people.length; i++) {
//            int candidate = -1;
//            for (int j = 0; j < people.length; j++) {
//                if (vis[j] == 1) continue;
//                int val = people[j][0];
//                int num = people[j][1];
//                int biggerOrEqualsThan = sum(bit, toIndex.get(val));
//                if (biggerOrEqualsThan == num && (candidate == -1 || people[candidate][0] > val)) {
//                    candidate = j;
//                }
//            }
//            ans[i] = people[candidate];
//            add(toIndex.get(people[candidate][0]), 1, bit);
//            vis[candidate] = 1;
//        }
//        return ans;
//    }
//
//    private int lowbit(int x) {
//        return x & -x;
//    }
//
//    private void add(int index, int val, int[] arr) {
//        while (index < arr.length) {
//            arr[index] += val;
//            index += lowbit(index);
//        }
//    }
//
//    private int sum(int[] arr, int index) {
//        int ans = 0;
//        while (index >= 1) {
//            ans += arr[index];
//            index -= lowbit(index);
//        }
//        return ans;
//    }
//
//    public int[][] reconstructQueue2(int[][] people) {
//        Arrays.sort(people, (a, b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
//        List<int[]> l = new ArrayList<>();
//        for (int[] p : people) {
//            l.add(p[1], p);
//        }
//        return l.toArray(new int[people.length][2]);
//    }
//
//    private static P406 p406 = new P406();
//
//    public static void main(String[] args) {
//        int[][] arr = new int[6][];
//        arr[0] = new int[]{7, 0};
//        arr[1] = new int[]{4, 4};
//        arr[2] = new int[]{7, 1};
//        arr[3] = new int[]{5, 0};
//        arr[4] = new int[]{6, 1};
//        arr[5] = new int[]{5, 2};
//        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
//        System.out.println(Arrays.deepToString(arr));
//        System.out.println(Arrays.deepToString(p406.reconstructQueue2(arr)));
//    }
//}
