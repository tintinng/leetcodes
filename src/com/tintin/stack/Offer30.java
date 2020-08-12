package com.tintin.stack;

import java.util.Arrays;

public class Offer30 {
    public static void main(String[] args) {
        MinStack0 minStack0 = new MinStack0();
        minStack0.push(-2);
        minStack0.push(0);
        minStack0.push(-3);
        minStack0.min();
    }
}

/**
 *  没有用到内置 stack数据结构，用数组存，有点费空间
 */
class MinStack0 {
    /** initialize your data structure here. */
    /**
     * 用数组来存储栈，top指向栈顶元素的下一个位置
     */
    private int[] stack;
    private int top;
    private int[] minStack;
    private int minTop;

    public MinStack0() {
        this.stack = new int[10];
        this.minStack = new int[10];
        this.top = 0;
        this.minTop = 0;
    }

    public void push(int x) {
        if (top >= stack.length) {
            stack = Arrays.copyOf(stack, stack.length*2);
        }
        if (minTop >= minStack.length) {
            minStack = Arrays.copyOf(minStack, minStack.length*2);
        }
        if (minTop==0 || x<=minStack[minTop-1]) {
            minStack[minTop++] = x;
        }
        stack[top++] = x;
    }

    public void pop() {
        if (top == 0) {
            return;
        }
        int x = stack[--top];
        if (minStack[minTop-1] == x) {
            minTop--;
        }
    }

    public int top() {
        if (top == 0) {
            return -1;
        } else {
            return stack[top-1];
        }
    }

    public int min() {
        return minStack[minTop-1];
    }
}
