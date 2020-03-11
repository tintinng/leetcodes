//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

  
  package com.tintin.leetcode.editor.cn;

import java.util.Stack;

class ValidParentheses{
      public static void main(String[] args) {
           Solution solution = new ValidParentheses().new Solution();
          String str = "[])";
          System.out.println(solution.isValid(str));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        int i = 0;
        Boolean flag = true;
        while(i<s.length()){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.empty()){//栈顶元素为反括号直接可判断
                    flag = false;
                    break;
                }
                char popChar = (char) stack.peek();
                switch (popChar){//比较栈顶元素和当前元素
                    case '{':
                        if (s.charAt(i)!='}'){
                            return false;
                        }
                        stack.pop();
                        break;
                    case '[':
                        if (s.charAt(i)!=']'){
                            return false;
                        }
                        stack.pop();
                        break;
                    case '(':
                        if (s.charAt(i)!=')'){
                            return false;
                        }
                        stack.pop();
                        break;
                    default:
                        return false;
                }
            }
            i++;
        }
        if (!stack.empty())
            flag = false;

        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
