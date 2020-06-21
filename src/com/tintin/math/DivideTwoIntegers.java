package com.tintin.math;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        int x = Integer.MAX_VALUE;
        int y = 1;
        System.out.println(solution29.divide(x,y));
        System.out.println(x/y);
    }
}


/**
 *  1、int中由于最小的负数的绝对值比最大的正数大1，因此防止溢出可以都转为负数来处理，用移位和加法操作确定;
 */
class Solution29 {
    public int divide(int dividend, int divisor) {
        int truncate = 0;
        int d = divisor;
        int i = 0;
        while (true) {
            if (d <= Integer.MAX_VALUE>>1) {
                d = d << 1;
                i++;
            }else {
                break;
            }
            if (d > dividend) {
                i--;
                d = d >> 1;
                break;
            }
        }
        truncate += Math.pow(2,i);
        i = 0;
        while (d < dividend) {
            if (d <= Integer.MAX_VALUE-divisor) {
                d += divisor;
                i++;
            }else {
                break;
            }
            if (d > dividend) {
                i--;
                break;
            }
        }
        truncate += i;

        return truncate;
    }
}
