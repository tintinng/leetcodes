package com.tintin.dp;

public class Offer46 {
    public static void main(String[] args) {
        SolutionOffer46 solutionOffer46 = new SolutionOffer46();
        System.out.println(solutionOffer46.translateNum(5552525));
    }
}

/**
 *  动态规划 (不转化成数组)
 *  1、 cur 表示前 n 位数的翻译方法，curPre表示前n-1位的翻译方法，prePre表示前n-2位的翻译方法。则
 *  2、转移方程：
 *      若 n位为 1或者 n位为 2且 n-1位大于 5时 —————— cur = curPre + prePre
 *      其他情况 —————— cur = curPre
 *  3、初始情况：一位数只有一种；两位数开始 prePre=1;curPre=1
 */
class SolutionOffer46 {
    public int translateNum(int num) {
        // 如果num是个位数，则至少有 1种方案
        int cur = 1;
        int curPre = 1;
        int prePre = 1;
        int preDigit = 0;

        // 从第二位开始，先除掉一位
        preDigit = num%10;
        num = num/10;

        // 循环遍历 num剩余各个位数
        while (num > 0) {
            int curDigit = num%10;
            if (curDigit==1 || (curDigit == 2 && preDigit <= 5)) {
                cur = curPre + prePre;
            } else {
                cur = curPre;
            }
            num = num/10;
            prePre = curPre;
            curPre = cur;
            preDigit = curDigit;
        }

        return cur;
    }
}
