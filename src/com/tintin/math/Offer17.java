package com.tintin.math;

import java.util.Arrays;

public class Offer17 {
    public static void main(String[] args) {
        SolutionOffer17 solutionOffer17 = new SolutionOffer17();
        System.out.println(Arrays.toString(solutionOffer17.printNumbers(4)));
    }
}

/**
 *  用字符串模拟大数问题！
 */
class SolutionOffer17 {
    public int[] printNumbers(int n) {
        int ceil = 1;
        while (n-- > 0) {
            ceil *= 10;
        }
        int[] nums = new int[ceil-1];
        for (int i=0; i<ceil-1; i++) {
            nums[i] = i+1;
        }
        return nums;
    }
    public int[] printNumbers1(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }


}