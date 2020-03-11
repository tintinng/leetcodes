//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串

  
  package com.tintin.leetcode.editor.cn;
  class ImplementStrstr{
      public static void main(String[] args) {
           KMP kmp = new KMP("ABABC");
          System.out.println(kmp.search("ABBBAABABC"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      public static class KMP {
          private int[][] dp;
          private String pat;

          public KMP(String pat) {
              this.pat = pat;
              int M = pat.length();
              // dp[状态][字符] = 下个状态
              dp = new int[M][256];
              // base case
              dp[0][pat.charAt(0)] = 1;
              // 影子状态 X 初始为 0
              int X = 0;
              // 构建状态转移图（稍改的更紧凑了）
              for (int j = 1; j < M; j++) {
                  for (int c = 0; c < 256; c++) {
                      if (pat.charAt(j) == c) {
                          dp[j][c] = j + 1;
                      } else {
                          dp[j][c] = dp[X][c];
                      }
                  }
                  // 更新影子状态
                  X = dp[X][pat.charAt(j)];
              }
          }
              public int search(String txt) {
                  int M = pat.length();
                  int N = txt.length();
                  // pat 的初始态为 0
                  int j = 0;
                  for (int i = 0; i < N; i++) {
                      // 当前是状态 j，遇到字符 txt[i]，
                      // pat 应该转移到哪个状态？
                      j = dp[j][txt.charAt(i)];
                      // 如果达到终止态，返回匹配开头的索引
                      if (j == M) {
                          return i - M + 1;
                      }
                  }
                  // 没到达终止态，匹配失败
                  return -1;
              }
//leetcode submit region end(Prohibit modification and deletion)

  }
  }
