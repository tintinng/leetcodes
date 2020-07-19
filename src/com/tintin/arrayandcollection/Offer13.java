package com.tintin.arrayandcollection;

public class Offer13 {
    public static void main(String[] args) {
        SolutionOffer13 solutionOffer13 = new SolutionOffer13();
        System.out.println(solutionOffer13.movingCount1(38,15,9));
    }
}

/**
 *  1、遍历 + 剪枝 (有些情况没办法产生斜线挡住)
 *      时间：O(m*n)
 *      空间：O(1)
 *  2、找到规律，i+j 和 i+1 + j-1 的值相同，即坐标格子上的数和左下角的数相同。
 *     遍历第一行或第一列（较长的），找到第一个不能到达的格子，经过这个格子的左
 *     下右上对角线可以堵住机器人，左边部分的格子数即为所求。
 */

class SolutionOffer13 {
    public int movingCount1(int m, int n, int k) {
        int count = 0;
        int temp = 0;
        for (int i=0; i<m; i++) {
            if (calculate(i) > k) {
                break;
            }
            for (int j=0; j<n; j++) {
                if (calculate(i) + calculate(j) > k) {
                    break;
                }else {
                    count++;
                }
            }
        }

        return count;
    }

    private int calculate(int num) {
        int result = 0;
        while (num > 0) {
            result += num%10;
            num = num/10;
        }

        return result;
    }
}
