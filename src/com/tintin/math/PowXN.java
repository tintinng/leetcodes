package com.tintin.math;

public class PowXN{
    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        double x = 2.00000;
        int n = -2;
        System.out.println(solution50.myPow(x,n));
    }
}

class Solution50{
    /**
     * 快速幂算法
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x,int n){
        // -2147483648转变成正数会越界，因此用long类型来代替
        long N = n;
        if(n<0){
            N = -N;
            x = 1/x;
        }
        if(N==0){
            return 1.000000;
        }
        if(N==1){
            return x;
        }
        double half = myPow(x, (int) (N/2));
        if(n%2==0){
            return half*half;
        }
        else {
            return half*half*x;
        }
    }
}
