package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaxHeap {

    private List<Integer> list;

    MaxHeap() {
        list = new ArrayList<>();
        list.add(-1);
    }

    MaxHeap(List<Integer> arr) {
        list = new ArrayList<>();
        list.add(-1); // dumb
        list.addAll(arr);
        for(int i = (arr.size() - 1) / 2; i > 0; i--) {
            goDown(i);
        }
    }

    public boolean empty() {
        return list.size() == 1;
    }

    public Integer get() {
        return list.get(0);
    }

    public void insert(Integer x) {
        list.add(x);
        goUp(list.size() - 1);
    }

    public Integer remove() {
        Integer ret = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list = list.subList(0, list.size() - 1);
        goDown(1);
        return ret;
    }

    private void goUp(int index) {
        while(index > 1) {
            if(list.get(index >> 1) > list.get(index)) return;
            int tmp = list.get(index >> 1);
            list.set(index >> 1, list.get(index));
            list.set(index, tmp);
            index >>= 1;
        }
    }

    private Integer getLeft(int index) {
        if(index << 1 > list.size() - 1) return null;
        return list.get(index << 1);
    }

    private Integer getRight(int index) {
//        System.out.println((index << 1) + 1);
        if((index << 1) + 1 > list.size() - 1) return null;
        return list.get((index << 1) + 1);
    }

    private void goDown(int now) {
        while(now <= list.size() - 1) {
            Integer left = getLeft(now);
            Integer right = getRight(now);
            if(left == null) return;
            else if(right == null) {
                if(list.get(now) >= left) return;
                int tmp = list.get(now);
                list.set(now, left);
                list.set(now << 1, tmp);
                now <<= 1;
            }
            else {
                if(list.get(now) < left && list.get(now) < right){
                    if(left < right) {
                        list.set((now << 1) + 1, list.get(now));
                        list.set(now, right);
                        now = (now << 1) + 1;
                    }
                    else {
                        list.set(now << 1, list.get(now));
                        list.set(now, left);
                        now <<= 1;
                    }
                }
                else if (list.get(now) < left) {
                    list.set(now << 1, list.get(now));
                    list.set(now, left);
                    now <<= 1;
                }
                else if (list.get(now) < right) {
                    list.set((now << 1) + 1, list.get(now));
                    list.set(now, right);
                    now = (now << 1) + 1;
                }
                else return;
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 31; i++) arr.add(random.nextInt());
//        arr.add(-1193143059);
//        arr.add(2);
        MaxHeap heap = new MaxHeap(arr);
        while(!heap.empty()) {
            System.out.println(heap.remove());
        }
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        while(!heap.empty()) {
            System.out.println(heap.remove());
        }
    }
}
