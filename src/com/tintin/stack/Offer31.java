package com.tintin.stack;

import java.util.Stack;

public class Offer31 {
    public static void main(String[] args) {

    }
}

/**
 *  遍历 pushed[] 和 popped[]
 *      时间：O(2*n)
 *      空间：O(n)
 */
class SolutionOffer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean flag = true;
        Stack<Integer> stack = new Stack<>();
        for (int i=0,j=0; i<pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[j]==stack.peek()) {
                stack.pop();
                j++;
            }
        }
        if (!stack.isEmpty()) {
            flag = false;
        }

        return flag;
    }
}
