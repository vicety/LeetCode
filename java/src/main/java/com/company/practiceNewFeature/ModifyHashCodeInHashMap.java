package com.company.practiceNewFeature;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class A{
    int index;
    int val;

    public A(int index, int val) {
        this.index = index;
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return index == a.index &&
                val == a.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, val);
    }
}

public class ModifyHashCodeInHashMap {

    private Map<A, Integer> mp = new HashMap<>();

    public static void main(String[] args) {
        ModifyHashCodeInHashMap mhcihm = new ModifyHashCodeInHashMap();
        A a = new A(1, 2);
        A a2 = new A(1, 2);
        System.out.println(a);
        System.out.println(a2);
        mhcihm.mp.put(a, 1);
        mhcihm.mp.put(a2, 2);
        System.out.println(mhcihm.mp.get(a) == mhcihm.mp.get(a2));
    }
}
