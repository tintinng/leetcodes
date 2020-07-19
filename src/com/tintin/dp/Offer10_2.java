package com.tintin.dp;

/**
 *  青蛙跳台阶问题
 */

public class Offer10_2 {
    public static void main(String[] args) {

    }
}

/**
 *  1、动态规划
 *    时间：O(N)
 *    空间：O(N)
 *  2、循环求余法，不需要开辟一个数组存储中间值，三个变量即可
 *    时间：O(N)
 *    空间：O(1)
*/

class SolutionOffer12_2 {
    public int numWays(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        if (n > 0) {
            f[1] = 1;
        }
        for (int i=2; i<n+1; i++) {
            f[i] = (f[i-1] + f[i-2]) % 1000000007;
        }

        return f[n];
    }
}