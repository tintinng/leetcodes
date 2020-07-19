package com.tintin.math;

/**
 *  二进制中 1 的个数
 */
public class Offer15 {
    public static void main(String[] args) {
        SolutionOffer15 solutionOffer15 = new SolutionOffer15();
        System.out.println(solutionOffer15.hammingWeight(Integer.MAX_VALUE));
    }
}

/**
 *  注意：注意负数的情况
 *
 *  1、使用 10进制转 2进制的方法
 *  2、与运算 + 移位操作
 *  3、n&(n-1)解析：二进制数字 n 最右边的 1 变成 0 ，其余不变
 */
class SolutionOffer15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n/2 > 0) {
            if (n%2 == 1) {
                count++;
            }
            n = n/2;
        }
        if (n%2 == 1) {
            count++;
        }

        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    public int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            n = n&(n-1);
            count ++;
        }
        return count;
    }
}