package com.tintin.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Offer40 {
    public static void main(String[] args) {
        int[] arr = new int[]{10,1,2,1};
        SolutionOffer40 solutionOffer40 = new SolutionOffer40();
        System.out.println(Arrays.toString(solutionOffer40.getLeastNumbers0(arr, 4)));
    }
}

/**
 *  1、使用堆
 *      时间：O(n*log(n))
 *      空间：O(n) 。使用小根堆堆中存储的元素是整个数组,使用大根堆则只需要在堆中存储 K个元素
 *
 *  2、使用快排是最有效的方法
 *
 */
class SolutionOffer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[] res = new int[k];
        for (int value : arr) {
            heap.add(value);
        }
        for (int i=0; i<k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }

    public int[] getLeastNumbers0(int[] arr, int k) {
        if(arr.length == 0 || k == 0) {
            return new int[]{};
        }

        return quickSearch(arr, 0, arr.length-1, k);
    }

    private int[] quickSearch(int[] arr, int p, int q, int k) {
        int pos = partition(arr, p, q);

        if (pos == k-1) {
            return Arrays.copyOf(arr, k);
        } else if (pos < k) {
            return quickSearch(arr, pos+1, q, k);
        } else {
            return quickSearch(arr, p, pos-1, k);
        }
    }

    /**
     * 用 arr[r]作为分区点将数组 arr分区
     * @param arr
     * @param l 分区后分区点的索引
     * @param r
     * @return
     */
    private int partition(int[] arr, int l, int r) {
        for(int i=l; i<r; i++) {
            if (arr[i] < arr[r]) {
                int temp = arr[i];
                arr[i] = arr[l];
                arr[l] = temp;
                l++;
            }
        }
        // 将最后一个用于分区的元素交换到索引为 l处
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;

        return l;
    }
}
