//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

  
  package com.tintin.leetcode.editor.cn;
  class LongestCommonPrefix{
      public static void main(String[] args) {
           Solution solution = new LongestCommonPrefix().new Solution();
           String[] strs = new String[]{};
          System.out.println(solution.longestCommonPrefix01(strs));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String longestCommonPrefix01(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length<1){
            return "";
        }
        String str = "";
        //找出最短的string
        String min_str = strs[0];
        for(int i=1;i<strs.length;i++)
        {
            if(strs[i].length() < min_str.length()){
                min_str = strs[i];
            }
        }
        //最长公共前缀最大只能是最短的string的长度
        for(int j=0;j<min_str.length();j++)
        {
            char cur_char = min_str.charAt(j);
            int k;
            for(k=0;k<strs.length;k++){
                if(strs[k].charAt(j)!=cur_char){
                    break;
                }
            }
            if(k==strs.length){
                str += cur_char;
            }
            else{
                break;
            }
        }

        return str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
