package com.tintin.arrayandcollection;

import java.util.HashMap;

public class Offer39 {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        SolutionOffer39 solutionOffer39 = new SolutionOffer39();
        System.out.println(solutionOffer39.majorityElement(nums));
    }
}

class SolutionOffer39 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (i=0; i<nums.length; i++) {
            Integer integer = nums[i];
            int count = map.getOrDefault(integer, 0);
            count++;
            if (count > nums.length/2) {
                break;
            }
            map.put(integer, count);
        }

        return nums[i];
    }
}
