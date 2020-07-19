package com.tintin.math;

/**
 *  剪绳子
 */
public class Offer14_1 {
    public static void main(String[] args) {

    }
}

/**
 *  1、数学推导：每段分成 3个长度，最后所得乘积最大
 */

class SolutionOffer14_1 {
    public int cuttingRope(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int res = 1;
        int k = n%3;
        int i = n/3;
        if (k == 0){
            res = (int)Math.pow(3,i);
        }else if (k == 1){
            res = (int)Math.pow(3,i-1)*4;
        }else {
            res = (int)Math.pow(3,i)*2;
        }

        return res;
    }
}