package com.tintin.arrayandcollection;

import java.util.Arrays;

public class RotateImage{
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
//                {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(Arrays.deepToString(matrix));
        Solution48 solution48 = new Solution48();
        solution48.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

class Solution48{
    /**
     * 从外圈往内圈，一圈圈rotate
     * @param matrix
     */
    public void rotate(int[][] matrix){
        if(matrix.length==0 || matrix.length!=matrix[0].length){
            return;
        }
        // n看作正方形的边长
        int len = matrix.length;
        // k表示从外向内的第k圈，最外圈为0;最内圈边长小于1时不需要rotate
        int k = 0;
        int[] temp = new int[len];
        while ((k+1)*2<=len){
            // 将二维数组看成一个正方形，保存上边的元素
            for(int i=0;i<len-k;i++){
                temp[i] = matrix[k][k+i];
            }
            // rotate一圈,注意（len-2*k-1）
            for(int i=0;i<len-2*k-1;i++){
                // 左边rotate到上边
                matrix[k][k+i] = matrix[len-1-k-i][k];
                // 下边rotate到左边
                matrix[len-1-k-i][k] = matrix[len-1-k][len-1-k-i];
                // 右边rotate到下边
                matrix[len-1-k][len-1-k-i] = matrix[k+i][len-1-k];
                // 上边rotate到右边
                matrix[k+i][len-1-k] = temp[i];
            }
            k++;
        }
    }

    /**
     * 转置+每一行翻转
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}