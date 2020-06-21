package com.tintin.arrayandcollection;

public class Offer04 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1},
                {2},
                {3},
                {10},
                {18}
        };
//        int[][] nums = new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
        SolutionOffer04 solutionOffer04 = new SolutionOffer04();
        System.out.println(solutionOffer04.findNumberIn2DArray(nums,0));
    }
}

/**
 *  1、从右上角到左下角依次比较。从 m[0][j-1] 开始，比当前值小则排除一列，比当前值大则排除一行
 */

class SolutionOffer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i<matrix.length && j>=0) {
            if (matrix[i][j] == target) {
                return true;
            }else if(matrix[i][j] > target) {
                j--;
            }else {
                i++;
            }
        }

        return false;
    }
}