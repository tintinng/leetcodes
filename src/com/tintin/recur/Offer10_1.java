package com.tintin.recur;

public class Offer10_1 {
    public static void main(String[] args) {
        System.out.println(new SolutionOffer10_1().fib2(45));
    }
}

/**
 *  1、递归
 *  2、动态规划
 *  3、循环求余，可以不用多余的数组
 */

class SolutionOffer10_1 {
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fib1(n-1) + fib1(n-2) )% (int)1e9+7;
    }

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i=2; i<=n; i++) {
            f[i] = (f[i-1] + f[i-2]) % 1000000007;
        }
        return f[n];
    }
}