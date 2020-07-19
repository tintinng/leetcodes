package com.tintin.stack;

import java.util.Queue;
import java.util.Stack;

public class Offer09 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        cQueue.appendTail(5);
        cQueue.appendTail(6);
        cQueue.appendTail(7);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

class CQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public CQueue(){
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if (stackOut.isEmpty()){
            if (stackIn.isEmpty()) {
                return -1;
            }else {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }

        return stackOut.pop();
    }

}