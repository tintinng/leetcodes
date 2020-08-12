package com.tintin.dp;

public class Offer42 {
    public static void main(String[] args) {
        SolutionOffer42 solutionOffer42 = new SolutionOffer42();
        int[] nums = new int[]{-2};
        System.out.println(solutionOffer42.maxSubArray(nums));
    }
}

/**
 *  1、f[n]表示以 nums[n]结尾的数组的 连续最大子数组之和
 *  2、转移方程
 *      f[n-1] > 0 : f[n] =  f[n-1] + nums[n]
 *      f[n-1] < 0 : f[n] = nums[n]
 *  3、初始条件
 *      f[0] = nums[0]
 *
 */
class SolutionOffer42 {
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int max = f[0];
        for (int i=1; i<nums.length; i++) {
            if (f[i-1] >= 0) {
                f[i] = f[i-1] + nums[i];
            } else {
                f[i] = nums[i];
            }
            max = Integer.max(f[i], max);
        }

        return max;
    }
}
