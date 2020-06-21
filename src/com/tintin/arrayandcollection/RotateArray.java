package com.tintin.arrayandcollection;

import java.util.Arrays;
import java.util.Collections;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        new Solution189().rotate(nums,9);
        System.out.println(Arrays.toString(nums));
    }
}

/**
 *  1、重新开辟一个大小相同的数组，先把后k个数先放入新数组，放前面的数。再copy回去
 *   时间复杂度：数组遍历一遍O(n)；
 *   空间复杂度：开辟一个大小相同的数组O(n)；
 *
 *  2、先reverse前 n-k个数，再reverse后k个数，再reverse整个数组。
 *   时间复杂度：数组遍历一遍O(n)；
 *   空间复杂度：反转交换两个数时使用一个temp O(1)；
 *
 *  3、暴力求解，一次rotate 1个；循环k次。
 *   时间复杂度：O(n*k)。每次rotate需要遍历一遍大小为n的数组，循环k次
 *   空间复杂度：O(1)。不需要使用额外空间。
 */
class Solution189 {

    /**
     *  交换两个数：
     *  1、使用中间变量
     *  2、a=a+b;b=a-b;a=a-b (a+b会溢出)
     *  3、异或 a=a^b;b=a^b;a=a^b
     *
     */
    private void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    /**
     * 2 ==>先reverse前 n-k个数，再reverse后k个数，再reverse整个数组。
     *    时间复杂度：数组遍历一遍O(n)；
     *    空间复杂度：反转交换两个数时使用一个temp O(1)；
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums,0,nums.length-1-k);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
}