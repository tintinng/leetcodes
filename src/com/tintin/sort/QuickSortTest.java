package com.tintin.sort;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1, 6, 4, 1};
        int[] arr = new int[]{1};
        Solution912_0 solution912_0 = new Solution912_0();
        System.out.println(Arrays.toString(solution912_0.sortArray(arr)));
    }
}

class Solution912_0{

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
//        Arrays.sort(nums);

        return nums;
    }

    /**
     *  分治思想，使用递归处理
     * @param arr
     * @param p
     * @param q
     */
    private void quickSort(int[] arr, int p, int q) {
        if(p < q) {
            int k = partition(arr, p, q);
            quickSort(arr, p, k-1);
            quickSort(arr, k+1, q);
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
            if (arr[i] <= arr[r]) {
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
