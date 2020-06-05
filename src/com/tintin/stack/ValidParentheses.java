package com.tintin.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "";
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid(s));
    }
}

class Solution20 {
    /**
     * 用一个map来维护括号之间的对应关系
     */
    private Map<Character,Character> map;

    public boolean isValid(String s) {
        map = new HashMap<>(3);
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            }
            else {
                if (!stack.isEmpty() && map.get(stack.peek()).equals(c)) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}