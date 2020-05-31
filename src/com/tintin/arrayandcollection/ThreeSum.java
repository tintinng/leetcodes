package com.tintin.arrayandcollection;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        Solution15 solution15 = new Solution15();
        System.out.println(solution15.threeSum(nums));
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            // 跳过相同的num，防止重复组合
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            // 固定一个数，另外两个数采用双指针思路
            while (left < right) {
                // 跳过相同的num，防止重复组合
                if (left > i+1 && nums[left] == nums[left-1]) {
                    left++;
                    continue;
                }
                if (right < nums.length-1 && nums[right] == nums[right+1]) {
                    right--;
                    continue;
                }
                // 双指针移动
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }else {
                    lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
            }
        }
        return lists;
    }
}
