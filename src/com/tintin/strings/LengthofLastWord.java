package com.tintin.strings;

public class LengthofLastWord {
    public static void main(String[] args) {
        String s = new String(" ");
        System.out.println(new Solution58().lengthOfLastWord(s));
    }
}

/**
 *  1、遍历两遍，第一遍记录下最后一个word的位置。第二次计算最后一个word的长度
 *    时间复杂度：O(n)
 *    空间复杂度：O(1)
 *  2、使用split函数用空格分割
 *    时间复杂度：
 *    空间复杂度：
 */
class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s.length()==0) {
            return 0;
        }
        String[] strs = s.split(" ");
        if (strs.length == 0) {
            return 0;
        }
        return strs[strs.length-1].length();
    }
}