package com.tintin.arrayandcollection;

public class Offer11 {
    public static void main(String[] args) {
        int[] numbers = new int[]{3,3,3};
        SolutionOffer11 solutionOffer11 = new SolutionOffer11();
        System.out.println(solutionOffer11.minArray1(numbers));
        System.out.println(solutionOffer11.minArray2(numbers));
    }
}

/**
 * 1、直接遍历
 *   时间：O(N)
 *   空间: O(1)
 * 2、二分查找
 *   时间：O(logN)
 *   空间: O(1)
 */

class SolutionOffer11 {
    public int minArray1(int[] numbers) {

        int i = 0;
        while (i < numbers.length-1) {
            if (numbers[i] <= numbers[i+1]) {
                i++;
            } else {
                break;
            }
        }
        if (i == numbers.length - 1) {
            return numbers[0];
        }
        return numbers[i+1];
    }

    public int minArray2(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }
}