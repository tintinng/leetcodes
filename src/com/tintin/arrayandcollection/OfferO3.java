package com.tintin.arrayandcollection;

import java.util.HashMap;
import java.util.HashSet;

public class OfferO3 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 3, 4, 5};
        SolutionOffer03 solution001 = new SolutionOffer03();
        System.out.println(solution001.findRepeatNumber(nums) + "--->" + solution001.findRepeatNumber2(nums));
    }
}

/**
 *  1、数组字典：使用一个大小为 n 的数组，遍历一遍原来的数组，原数组的值作为新数组的下标访问
 *     新数组。count[x]表示数 x 在原数组的数量
 *    时间：O(n)
 *    空间：O(n)
 *  2、使用哈希表。
 *    时间：O(n)
 *    空间：O(n)
 */

class SolutionOffer03 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length ;
        int[] counts = new int[n];
        for (int i=0; i<n; i++) {
            if (counts[nums[i]] != 0) {
                return nums[i];
            }
            counts[nums[i]]++;
        }

        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return num;
            }
            hashSet.add(num);
        }

        return -1;
    }
}