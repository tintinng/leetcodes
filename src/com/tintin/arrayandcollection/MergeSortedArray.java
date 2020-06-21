package com.tintin.arrayandcollection;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        Solution88 solution88 = new Solution88();
        solution88.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}

/**
 *  1、类似mergeSort的merge操作，新开辟一个数组，遍历nums1和nums2放入新数组，再copy到nums1
 *   时间复杂度：O(m+n)
 *   空间复杂度：O(m+n)
 *
 *  2、类似插入排序，将nums2依次插入进nums1中的合适的位置
 *   时间复杂度：O(m*n)
 *   空间复杂度：O(1)
 *
 *  3、合并后排序
 *   时间复杂度：O((m*n)log(m*n))
 *   空间复杂度：O(1)
 *
 *  4、双指针，从后往前，不用开辟额外的数组
 *   时间复杂度：O(m+n)
 *   空间复杂度：O(1)
 */
class Solution88 {

    /**
     * 2==> 可以优化为只用开辟 m 大小的数组
     *
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while (i<m && j<n) {
            if (nums1[i] <= nums2[j]) {
                num[k] = nums1[i++];
            }else {
                num[k] = nums2[j++];
            }
            k++;
        }
        while (i < m) {
            num[k++] = nums1[i++];
        }
        while (j < n) {
            num[k++] = nums2[j++];
        }

        System.arraycopy(num,0,nums1,0,m+n);
    }
}
