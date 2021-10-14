package com.company.leetCode;

import java.util.*;

public class P76 {
//    public String minWindow(String s, String t) {
//        Map<Character, Integer> tMp = new HashMap<>();
//        Map<Character, Integer> nowMp = new HashMap<>();
//        Deque<Integer> dq = new LinkedList<>();
//        int l = 0, r = -1, minLen = Integer.MAX_VALUE;
//        for (int i = 0; i < t.length(); i++) {
//            tMp.computeIfPresent(t.charAt(i), (k, v) -> v + 1);
//            tMp.putIfAbsent(t.charAt(i), 1);
//        }
//        int cnt = tMp.keySet().size();
//        int nowCnt = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (tMp.containsKey(s.charAt(i))) {
////                if (!dq.isEmpty() && s.charAt(i) == s.charAt(dq.peekFirst()) && nowCnt >= cnt) {
////                    nowMp.put(s.charAt(dq.peekFirst()), nowMp.get(s.charAt(dq.peekFirst())) - 1);
////                    dq.pollFirst();
////                    while(!dq.isEmpty() && nowMp.get(s.charAt(dq.peekFirst()))  > tMp.get(s.charAt(dq.peekFirst()))) {
////                        nowMp.put(s.charAt(dq.peekFirst()), nowMp.get(s.charAt(dq.peekFirst())) - 1);
////                        dq.pollFirst();
////                    }
////                }
//                dq.addLast(i);
//                nowMp.computeIfPresent(s.charAt(i), (k, v) -> v + 1);
//                nowMp.putIfAbsent(s.charAt(i), 1);
//                if(nowMp.get(s.charAt(i)) == tMp.get(s.charAt(i))) nowCnt++;
//                while (!dq.isEmpty() && nowMp.get(s.charAt(dq.peekFirst())) > tMp.get(s.charAt(dq.peekFirst()))) {
//                    nowMp.put(s.charAt(dq.peekFirst()), nowMp.get(s.charAt(dq.peekFirst())) - 1);
//                    dq.pollFirst();
//                }
//                if(nowCnt >= cnt && dq.peekLast() - dq.peekFirst() < minLen) {
//                    l = dq.peekFirst();
//                    r = dq.peekLast();
//                    minLen = r - l;
//                }
//            }
//        }
//        return s.substring(l, r + 1);
//    }

    public String minWindow(String source, String target) {
        Map<Character, Integer> tMp = new HashMap<>();
        Map<Character, Integer> nowMp = new HashMap<>();
        Deque<Integer> dq = new LinkedList<>();
        int l = 0, r = -1, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < target.length(); i++) {
            tMp.computeIfPresent(target.charAt(i), (k, v) -> v + 1);
            tMp.putIfAbsent(target.charAt(i), 1);
        }
        int cnt = tMp.keySet().size();
        int nowCnt = 0;
        for (int i = 0; i < source.length(); i++) {
            if (tMp.containsKey(source.charAt(i))) {
//                if (!dq.isEmpty() && source.charAt(i) == source.charAt(dq.peekFirst()) && nowCnt >= cnt) {
//                    nowMp.put(source.charAt(dq.peekFirst()), nowMp.get(source.charAt(dq.peekFirst())) - 1);
//                    dq.pollFirst();
//                    while(!dq.isEmpty() && nowMp.get(source.charAt(dq.peekFirst()))  > tMp.get(source.charAt(dq.peekFirst()))) {
//                        nowMp.put(source.charAt(dq.peekFirst()), nowMp.get(source.charAt(dq.peekFirst())) - 1);
//                        dq.pollFirst();
//                    }
//                }
                dq.addLast(i);
                nowMp.computeIfPresent(source.charAt(i), (k, v) -> v + 1);
                nowMp.putIfAbsent(source.charAt(i), 1);
                if(nowMp.get(source.charAt(i)) == tMp.get(source.charAt(i))) nowCnt++;
                while (!dq.isEmpty() && nowMp.get(source.charAt(dq.peekFirst())) > tMp.get(source.charAt(dq.peekFirst()))) {
                    nowMp.put(source.charAt(dq.peekFirst()), nowMp.get(source.charAt(dq.peekFirst())) - 1);
                    dq.pollFirst();
                }
                if(nowCnt >= cnt && dq.peekLast() - dq.peekFirst() < minLen) {
                    l = dq.peekFirst();
                    r = dq.peekLast();
                    minLen = r - l;
                }
            }
        }
        return source.substring(l, r + 1);
    }

    public static void main(String[] args) {
        P76 p76 = new P76();
//        System.out.println(p76.minWindow("ABBBDCCBCBA", "ABCC"));
    }
}
