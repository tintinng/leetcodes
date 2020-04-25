package com.tintin.heap;

import java.util.*;

public class TopKFrequentElements{
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3,4,4,4,6,7,7,6,6,6,6};
        int k = 2;
//        Solution347 solution347 = new Solution347();
        Solution0 solution0 = new Solution0();
//        System.out.println(Arrays.toString(solution347.topKFrequent(nums, k)));
        System.out.println(solution0.topKFrequent(nums,k));
    }
}

class Solution347{
    public int[] topKFrequent(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int value = 1;
            if(map.containsKey(nums[i])){
                value = map.get(nums[i]) + 1;
            }
            map.put(nums[i],value);
        }
        //建立一个大小为 K的小顶堆（用数组表示）
        int[] heapK = new int[k];
        for(int i=0;i<k;i++){
            heapK[i] = 0;
        }

        //遍历 map,将前 K大的 value对应 key加入堆
        int j = 0;
        for (Integer key:map.keySet()) {
            if(heapK[0]==0 || map.get(key)>map.get(heapK[0])){
                //堆中插入元素
                heapK[0] = key;
                //堆化
                heapfy(heapK,map,k);
            }
        }


        return heapK;
    }

    // 堆化
    public void heapfy(int[] heap,Map<Integer,Integer> map,int len){
        int maxPos = 0;
        while(maxPos<len){
            int originPos = maxPos;
            if((maxPos+1)*2-1<len && map.get(heap[(maxPos+1)*2-1])<map.get(heap[maxPos])){
                maxPos = (maxPos+1)*2-1;
            }
            if((maxPos+1)*2<len && map.get(heap[(maxPos+1)*2])<map.get(heap[maxPos])){
                maxPos = (maxPos+1)*2;
            }
            // 堆化完成
            if(originPos==maxPos){
                break;
            }
            swap(heap,originPos,maxPos);
        }
    }

    //交换两数
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution0{
    public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        // 关键一步，通过lambda表达式自定义Comparator，建堆add()时传入的参数是key，而比较的是value。
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }
}
