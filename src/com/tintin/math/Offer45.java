package com.tintin.math;

import java.util.Arrays;
import java.util.Comparator;

public class Offer45 {
    public static void main(String[] args) {
        SolutionOffer45 solutionOffer45 = new SolutionOffer45();
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(solutionOffer45.minNumber2(nums));
    }
}

/**
 *  1、给字符串排序
 *  2、使用内置排序函数
 */
class SolutionOffer45 {
    public String minNumber2(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (x, y)->(x+y).compareTo(y+x));

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }
}
