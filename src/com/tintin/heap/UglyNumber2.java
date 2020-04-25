package com.tintin.heap;

import java.util.*;

public class UglyNumber2{
    public static void main(String[] args) {
        System.out.println(new Solution264().nthUglyNumber(10));
    }
}

class Solution264{
    public int nthUglyNumber(int n){
        //
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> hashSet = new HashSet<>();
        int heapTop = 1;
        heap.add(heapTop);
        hashSet.add(heapTop);
        int[] nums = new int[]{2,3,5};
        List<Integer> list = new ArrayList<>();
        while (list.size()<n){
            heapTop = heap.poll();
            list.add(heapTop);
            // 将heap中的值乘堆顶值再加入堆
            for (int num : nums) {
                int e = heapTop * num;
                // 判断元素是否重复
                if(!hashSet.contains(e)){
                    hashSet.add(e);
                    heap.add(e);
                }
            }
        }

        // 最后从堆中删除的即为第n小的数
        return heapTop;
    }
}
