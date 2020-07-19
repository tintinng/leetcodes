package com.tintin.backtracking;

public class Offer13 {
    public static void main(String[] args) {
        SolutionOffer13 solutionOffer13 = new SolutionOffer13();
        System.out.println(solutionOffer13.movingCount(16,8,4));
    }
}

/**
 *  1、深搜（完成）
 *  2、广搜（下次试一下）
 */

class SolutionOffer13 {
    private int count;
    private int m;
    private int n;

    public int movingCount(int m,int n, int k) {
        this.count = 0;
        this.m = m;
        this.n = n;
        boolean[][] visited = new boolean[m][n];
        backtrace(0,0,k,visited);

        return count;
    }

    private void backtrace(int i, int j,int k,boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }
        if (calculate(i) + calculate(j) <= k) {
            count++;
        } else {
            return;
        }
        visited[i][j] = true;
        if (i-1 >= 0) {
            backtrace(i-1,j,k,visited);
        }
        if (j+1 < n) {
            backtrace(i,j+1,k,visited);
        }
        if (i+1 < m) {
            backtrace(i+1,j,k,visited);
        }
        if (j-1 >= 0) {
            backtrace(i,j-1,k,visited);
        }
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