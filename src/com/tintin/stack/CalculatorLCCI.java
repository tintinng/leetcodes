package com.tintin.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.Stack;

public class CalculatorLCCI {
    public static void main(String[] args) {
        String str = new String("3/4+2*2  /3-3  ");
        Solution1626 solution1626 = new Solution1626();
        System.out.println(solution1626.calculate(str));
    }
}

class Solution1626{
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> opts = new Stack<Character>();
        // 存放+ - * /的优先级
        Map<Character,Integer> priority = new HashMap<Character,Integer>();
        priority.put('+',1);
        priority.put('-',1);
        priority.put('*',2);
        priority.put('/',2);
        int res = 0;
        s = s.trim();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }
            // 操作数
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                nums.push(s.charAt(i) - '0');
                if(i!=s.length()-1){
                    continue;
                }
            }
            // 运算符 或者最后一个操作数
            // 当前运算符的优先级，若到达结尾此时优先级最小最小
            int curPriority = (i==s.length()-1) ? -1 : priority.get(s.charAt(i));
            if(opts.isEmpty() || priority.get(opts.peek()) < curPriority){
                opts.push(s.charAt(i));
                continue;
            }
            // 栈不为空，且栈顶元素优先级高
            while (!opts.isEmpty() && priority.get(opts.peek()) >= curPriority) {
                int num2 = nums.pop();
                int num1 = nums.pop();
                int tempRes = 0;
                switch (opts.pop()) {
                            case '+':
                                tempRes = num1 + num2;
                                break;
                            case '-':
                                tempRes = num1 - num2;
                                break;
                            case '*':
                                tempRes = num1 * num2;
                                break;
                            case '/':
                                tempRes = num1 / num2;
                                break;
                            default: return -1;
                }
                nums.push(tempRes);
            }
            if(curPriority!=-1){
                opts.push(s.charAt(i));
            }
        }
        res = nums.pop();

        return res;
    }
}
