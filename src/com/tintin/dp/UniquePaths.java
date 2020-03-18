package com.tintin.dp;

public class UniquePaths{
    public static void main(String[] args) {
        int m = 0;
        int n = 0;
        int obstacleGrid[][] = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        Solution62 solution62 = new Solution62();
//        System.out.println(solution62.solute(1,1));
        System.out.println(solution62.solute63(obstacleGrid));

    }
}

class Solution62{
    public int solute(int m,int n){
        //1、确定状态 f[i][j]表示到 (i,j)处一共有多少种走法
        //2、转移方程 f[i][j] = f[i-1][j] + f[i][j-1]
        //3、考虑边界情况：
        //  上面没有格子：f[i][j] = f[i-1][j]
        //  左边没有格子：f[i][j] = f[i][j-1]
        //4、从f[0][0]计算到f[n-1][m-1]
        int f[][] = new int[n][m];
        f[0][0] = 1;

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(i-1<0 && j-1>=0){
                    f[i][j] = f[i][j-1];
                }
                else if(i-1>=0 && j-1<0){
                    f[i][j] = f[i-1][j];
                }else if(i-1>=0 && j-1>=0){
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }

        return f[n-1][m-1];
    }

    public int solute63(int[][] obstacleGrid){
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int f[][] = new int[n][m];
        //左侧和上侧只可能是1,若是obstacle则为0
        for(int i=0;i<n;++i){
            if(obstacleGrid[i][0]!=0){
                f[i][0] = 0;
                break;
            }
            else {
                f[i][0] = 1;
            }
        }
        for(int j=0;j<m;++j){
            if(obstacleGrid[0][j]!=0){
                f[0][j] = 0;
                break;
            }
            else {
                f[0][j] = 1;
            }
        }

        for(int i=1;i<n;++i){
            for(int j=1;j<m;++j){
                if(obstacleGrid[i][j]==0){
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
                else {
                    f[i][j] = 0;
                }
            }
        }

        return f[n-1][m-1];
    }
}