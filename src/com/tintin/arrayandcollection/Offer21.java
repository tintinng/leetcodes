package com.tintin.arrayandcollection;

import java.util.Arrays;

public class Offer21 {
    public static void main(String[] args) {
        SolutionOffer21 solutionOffer21 = new SolutionOffer21();
        int[] nums =  new int[]{};
        System.out.println(Arrays.toString(solutionOffer21.exchange(nums)));
    }
}

/**
 *  1、双指针，一个从前往后遍历找偶数的位置，一个从后往前遍历找奇数，交换偶数和奇数
 *      时间：O(n)
 *      空间：O(1)
 */

class SolutionOffer21 {
    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            if ((nums[l]&1) == 0 && (nums[r]&1) == 1){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
                continue;
            }
            if ((nums[l]&1) == 1){
                l++;
            }
            if ((nums[r]&1) == 0){
                r--;
            }
        }

        return nums;
    }
}