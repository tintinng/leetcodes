package com.tintin.arrayandcollection;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9};
        Solution66 solution66 = new Solution66();
        System.out.println(Arrays.toString(solution66.plusOne(digits)));
    }
}

/**
 * 1、从后往前遍历，遇到9则进位，若是数组的第一个元素，则改为1，
 *    把后面所有元素改为0，并在末尾加一个为0的元素
 *      时间复杂度：O(n)
 *      空间复杂度：O(1)
 */

class Solution66 {
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--) {
            int val = digits[i] + 1;
            if (val != 10) {
                digits[i] = val;
                break;
            }else {
                if (i == 0) {
                    digits[i] = 1;
                    int[] rst = new int[digits.length+1];
//                    System.arraycopy(digits,0,rst,0,digits.length);
//                    rst[digits.length] = 0;
                    rst[0] = 1;
                    return rst;
                }else {
                    digits[i] = 0;
                }
            }
        }

        return digits;
    }
}