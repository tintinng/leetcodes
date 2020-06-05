package com.tintin.stack;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        Solution155 solution155 = new Solution155();
        solution155.push(2);
        solution155.push(3);
        solution155.push(1);
        solution155.push(4);
        solution155.push(5);
        System.out.println(solution155.toString());
        System.out.println(solution155.getMin());
        System.out.println(solution155.top());
        solution155.pop();
        solution155.pop();
        solution155.pop();
        System.out.println(solution155.toString());
        System.out.println(solution155.getMin());
        System.out.println(solution155.top());
    }
}

class Solution155 {

    /**
     * minStack用于维护当前栈中的最小元素，最小元素在 top
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public Solution155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
            return;
        }
        // 判断入栈元素是否为最小元素
        if (minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    @Override
    public String toString() {
        return "Solution155{" +
                "stack=" + stack +
                ", minStack=" + minStack +
                '}';
    }
}
