package com.tintin.math;

public class Offer43 {
    public static void main(String[] args) {
        SolutionOffer43 solutionOffer43 = new SolutionOffer43();
        System.out.println(solutionOffer43.countDigitOne(10240001));
    }
}

/**
 *  1、傻瓜遍历超时
 *      时间：O(n*k),k为 n的位数
 *      空间：O(1)
 *  2、找规律
 *  3、递归
 */
class SolutionOffer43 {
    public int countDigitOne(int n) {
        int count = 0;
        for (int i=1; i<=n; i++) {
            count += countOne(i);
        }

        return count;
    }

    private int countOne(int n) {
        int count = 0;
        while (n > 0) {
            int num = n%10;
            if (num == 1) {
                count++;
            }
            n = n/10;
        }
        return count;
    }
}
