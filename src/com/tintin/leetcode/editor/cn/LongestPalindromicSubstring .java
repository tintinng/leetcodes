//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

  
  package com.tintin.leetcode.editor.cn;

import java.util.Scanner;

class LongestPalindromicSubstring{
      public static void main(String[] args) {
           Solution solution = new LongestPalindromicSubstring().new Solution();
           Scanner in = new Scanner(System.in);
           String str = in.nextLine();
//          String str  = "ababc";
           System.out.println(solution.longestPalindrome(str));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1)
            return "";
        int start = 0;  //    最长子串头
        int end = 0;    //  最长子串尾
        for(int i=0;i<s.length()-1;i++)
        {
            int len1 = Expanding(i,i,s);
            int len2 = Expanding(i,i+1,s);
            int len = Math.max(len1,len2);
            if(len > end-start+1){    //  更新最长子串头和尾
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start,end+1);
    }

    public int Expanding(int left,int right,String s){
        if(s.charAt(left)!=s.charAt(right))
            return 1;
        while(left-1>=0 && right+1<s.length() && s.charAt(left-1)==s.charAt(right+1))
        {
            left--;
            right++;
        }
        return right-left+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
