package com.company.leetCode;

import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P135 {
    class Item{
        int index;
        int val;

        public Item(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public int candy(int[] ratings) {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < ratings.length; i++) {
            list.add(new Item(i, ratings[i]));
        }
        list.sort(Comparator.comparingInt(item -> item.val));
        int[] dist = new int[ratings.length];
        for (Item item : list) {
            int min = 1;
            if(item.index - 1 >= 0 && ratings[item.index] > ratings[item.index - 1]) min = Math.max(min, dist[item.index - 1] + 1);
            if(item.index + 1 < list.size() && ratings[item.index] > ratings[item.index + 1]) min = Math.max(min, dist[item.index + 1] + 1);
            dist[item.index] = min;
        }
        int ans = 0;
        for (int i : dist) {
            ans += i;
            System.out.print(i + " ");
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println((new P135()).candy(new int[]{3, 2, 1, 0, 0, 1, 1,2, 1, 0, 1, 2, 1}));
    }
}
