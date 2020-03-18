package com.tintin.dp;

import java.util.List;

public class MaxmumSubArray{
    public static void main(String[] args) {
        int nums[] = new int[]{-2};
        Solution53 solution = new Solution53();
        System.out.println(solution.solute(nums));
    }
}
class Solution53{
    public int solute(int[] array){
        int maxSum = array[0];
        int n = array.length;
        //1、确定状态
        int[] f = new int[n];
        //2、转移方程 f(k) = max{ f(k-1)+array[k] , f(k) } 以第k个位置结尾最优解（和最大）
        //3、确定初始条件
        f = array;
        //4、从前往后计算
        for(int i=1;i<n;++i){
            f[i] = Math.max(f[i],f[i-1]+array[i]);
            maxSum = Math.max(f[i], maxSum);
        }

        return maxSum;
    }
}
