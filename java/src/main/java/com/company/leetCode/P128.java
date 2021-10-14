package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P128 {
    class Unit {
        int fa;
        int val;
        int size;

        public Unit(int fa, int val, int size) {
            this.fa = fa;
            this.val = val;
            this.size = size;
        }
    }

    Map<Integer, Unit> mp;

    private Unit find(Unit item) {
        if (item.fa == item.val) return item;
        item.fa = find(mp.get(item.fa)).val;
        return mp.get(item.fa);
    }

    private void bind(Unit a, Unit b) {
        Unit afa = find(a);
        Unit bfa = find(b);
        afa.fa = bfa.val;
        bfa.size += afa.size;
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        mp = new HashMap<>();
        for (int num : nums) {
            if (mp.get(num) != null) continue;
            mp.put(num, new Unit(num, num, 1));
            if (mp.get(num - 1) != null) bind(mp.get(num), mp.get(num - 1));
            if (mp.get(num + 1) != null) bind(mp.get(num), mp.get(num + 1));
        }
        int ans = Integer.MIN_VALUE;
        for (int num : mp.keySet()) {
            ans = Math.max(ans, mp.get(num).size);
        }
        return ans;
    }
}
