package com.tintin.dp;

public class MinimunPathSum{
    public static void main(String[] args) {
        int nums[][] = new int[][]{
                {1},
                {4}
        };

        Solution64 solution64 = new Solution64();
        System.out.println(solution64.minPathSum(nums));
    }
}

class Solution64{
    /**
     * 1、f[i][j]表示到达grid[i][j]的最小权值和路径
     * 2、则：f[i][j] = Min{ f[i][j-1] , f[i-1][j] } + grid[i][j]
     * 3、第一行和第一列的 f[i][j]可以确定
     *      只有一行或一列;数组为空
     * 4、for循环，计算f[m-1][n-1]即为结果
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }

        // 行数
        int m = grid.length;
        // 列数
        int n = grid[0].length;
        int f[][] = new int[m][n];

        f[0][0] = grid[0][0];
        // 行数大于 1
        if(m>1){
            for(int i=1;i<m;i++){
                f[i][0] = f[i-1][0] + grid[i][0];
            }
        }
        // 列数大于 1
        if(n>1){
            for(int j=1;j<n;j++){
                f[0][j] = f[0][j-1] + grid[0][j];
            }
        }
        // 行数和列数都大于 1
        if(m>1 && n>1){
            for(int i=1;i<m;i++){
                for (int j=1;j<n;j++){
                    f[i][j] = Math.min(f[i][j-1] , f[i-1][j]) + grid[i][j];
                }
            }
        }

        return f[m-1][n-1];
    }
}
