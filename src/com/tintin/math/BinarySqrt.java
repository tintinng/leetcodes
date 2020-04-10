package com.tintin.math;

public class BinarySqrt{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sqrt_search(2));
    }
}

class Solution{
    // 明确精度到底是什么意思？ 上界限和下界限之差在0.000001以内即可以保证mid的精度为0.000001
    public double sqrt_search(float n){
        if(n==1){
            return 1;
        }
        double mid = 0.0f;
        if(n < -1e-6){
            // 小于0，抛异常
            throw new IllegalArgumentException();
        }else if(Math.abs(n) >= -1e-6 && Math.abs(n) <= 1e-6){
            return mid;
        }else{
            // 如果n>4，默认平方根的不会超过n的一半
            double high = n / 2.0;
            double low = 0.0;
            if(n<4){
                high = n;
            }
            while(Math.abs(high - low) > 1e-6){
                // 首先找到中间值
                mid = low + (high - low) / 2;
                double tmp = mid * mid;
                // 比较并更新 high和low
                if((tmp - n) > 0){
                    high = mid;
                }
                if((tmp -n) < 0){
                    low = mid;
                }
            }
        }
        // 保留6位小数
        return Math.round(mid*1e6)/1e6;
    }
}