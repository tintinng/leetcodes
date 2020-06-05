package com.tintin.stack;

import java.util.Stack;

public class StackTest{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int i = stack.push(2);
        boolean b = stack.add(3);
        stack.push(4);
        stack.set(1,8);
        stack.push(5);
        stack.push(6);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        System.out.println(stack);

        stack.add(100);
        stack.remove(3);
        System.out.println(stack);
//        System.out.println(stack.search(3));
//        System.out.println(stack.search(8));
//        System.out.println(stack.size()-1);
//        System.out.println(stack.size());
//        System.out.println(stack);
//        System.out.println(i);
//        System.out.println(b);
//        Integer[] nums = new Integer[]{0,0,2};
//        nums[2] = null;
//        System.out.println(nums);
    }
}
