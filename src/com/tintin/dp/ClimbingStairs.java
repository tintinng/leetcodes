package com.tintin.dp;

public class ClimbingStairs{
    public static void main(String[] args) {
        int n = 2;
        Solution70 solution70 = new Solution70();
        System.out.println(solution70.solute(n));
    }
}

class Solution70{
    public int solute(int n){
        //1、确定状态：f[i]代表跳到第i层一共有的不同路径数
        //2、转移方程:f[i] = f[i-1] + f[i-2]
        //3、边界 f[0] = 1;f[1] = 1;f[2] = 2
        //4、从1~n计算f[i]
        if(n==0 || n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int f[] = new int[n+1];
        f[1] = 1;
        f[2] = 2;
        for(int i=3;i<=n;++i){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }
}