package com.tintin.stack;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,3,65,2,1,4,2,7,8,4};
        int k = 5;
        Solution239 solution239 = new Solution239();
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }
}

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return null;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<k; i++) {
            heap.add(nums[i]);
        }
        list.add(heap.peek());
        for (int i=0,j=k; j<nums.length; i++,j++) {
            heap.add(nums[j]);
            heap.remove(nums[i]);
            list.add(heap.peek());
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}

/**
 * 使用双端队列
 */
class Solution {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
         for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }
}
