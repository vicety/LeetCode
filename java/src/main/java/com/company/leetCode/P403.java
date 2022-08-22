//package com.company.leetCode;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
///**
// * @author vicety
// * @date 2020/4/10 1:36
// */
//public class P403 {
//    private class State {
//        int now;
//        int pace;
//
//        public State(int now, int pace) {
//            this.now = now;
//            this.pace = pace;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            State state = (State) o;
//            return now == state.now &&
//                    pace == state.pace;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(now, pace);
//        }
//    }
//
//    public boolean canCross(int[] stones) {
//        Set<Integer> stonesSet = new HashSet<>();
//        for (int stone : stones) stonesSet.add(stone);
//        return dfs(new HashSet<>(), stonesSet, new State(0, 0), stones[stones.length - 1]);
//    }
//
//    private boolean dfs(Set<State> vis, Set<Integer> stones, State nowState, int target) {
//        if (nowState.now == target) {
//            return true;
//        }
//        for (int i = -1; i <= 1; i++) {
//            int pace = nowState.pace + i;
//            State nextState = new State(nowState.now + pace, pace);
//            if (pace <= 0 || vis.contains(nextState) || !stones.contains(nextState.now)) continue;
//            vis.add(nextState);
//            if (dfs(vis, stones, nextState, target)) return true;
//        }
////
////        for (int i = -1; i <= 1; i++) {
////            int pace = nowState.pace + i;
////            State nextState = new State(nowState.now - pace, pace);
////            if (nextState.now < 0 || pace <= 0 || vis.contains(nextState) || !stones.contains(nextState.now)) continue;
////            vis.add(nextState);
////            if (dfs(vis, stones, nextState, target)) return true;
////        }
//        return false;
//    }
//
//    private static P403 p403 = new P403();
//
//    @Test
//    private void test1() {
//        Assert.assertTrue(p403.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
//    }
//
//    @Test
//    private void test2() {
//        Assert.assertFalse(p403.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
//    }
//}
