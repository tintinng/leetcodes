//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: 3
//输出: "III" 
//
// 示例 2: 
//
// 输入: 4
//输出: "IV" 
//
// 示例 3: 
//
// 输入: 9
//输出: "IX" 
//
// 示例 4: 
//
// 输入: 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串

  
  package com.tintin.leetcode.editor.cn;
  class IntegerToRoman{
      public static void main(String[] args) {
           Solution solution = new IntegerToRoman().new Solution();
          System.out.println(solution.intToRoman(904));
      }

class Solution1 {
    public String intToRoman(int num) {
        int x = num;
        String str = "";

        int thou = x/1000;
        x = x%1000;
        for(int i=0;i<thou;i++)
            str += 'M';

        while(x>0){
            char char1,char5,char10;
            int devi;
            if(x>=100 && x<1000){
                char1 = 'C';
                char5 = 'D';
                char10 = 'M';
                devi = 100;
            }
            else if(x>=10 && x<100){
                char1 = 'X';
                char5 = 'L';
                char10 = 'C';
                devi = 10;
            }
            else{
                char1 = 'I';
                char5 = 'V';
                char10 = 'X';
                devi = 1;
            }

            int rs = x/devi;
            if(rs == 9){
                str = str + char1 + char10;
            }
            else if(rs>=5 && rs<=8){
                str += char5;
                for(int i=0;i<rs-5;i++)
                    str += char1;
            }
            else if(rs == 4){
                str = str + char1 + char5;
            }
            else{
                for(int i=0;i<rs;i++)
                    str += char1;
            }

            x = x%devi;
        }

        return str;
    }
}

      class Solution {
          public String intToRoman(int num) {
              StringBuilder ans = new StringBuilder();
              String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  // 罗马数字
              int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  // 阿拉伯数字
              int index = 0;
              while (num > 0) {
                  int count = num / arab[index];
                  while (count-- > 0) {
                      ans.append(roman[index]);
                  }
                  num %= arab[index];
                  index++;
              }
              return ans.toString();
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }
