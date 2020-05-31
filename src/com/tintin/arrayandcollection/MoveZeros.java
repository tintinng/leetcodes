package com.tintin.arrayandcollection;

/**
 * @author tintin
 */
public class MoveZeros{
    public static void main(String[] args) {
        int[] nums = new int[] {2,1};
        Solution283 solution283 = new Solution283();
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i]);
        }
        solution283.moveZeroes(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}

class Solution283{


    /**
     * 1、找到一个稳定的排序算法即可（麻烦）
     * @param nums
     */
//    public void moveZeroes(int[] nums) {
//        if (nums.length == 0) {
//            return;
//        }
//
//        for (int i=0; i<nums.length; i++) {
//            if (nums[i] == 0) {
//                continue;
//            }
//            else {
//                // 遇到的第一个不为0的数，和前面的第一个0交换位置
//                for (int j=0; j<i; j++) {
//                    if (nums[j] == 0) {
//                        nums[j] = nums[i];
//                        nums[i] = 0;
//                    }
//                }
//            }
//        }
//    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        // 表示数组中第一个0的位置
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
