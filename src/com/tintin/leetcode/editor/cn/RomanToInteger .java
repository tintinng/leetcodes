//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
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
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串

  
  package com.tintin.leetcode.editor.cn;
  class RomanToInteger{
      public static void main(String[] args) {
           Solution solution = new RomanToInteger().new Solution();
           System.out.println(solution.romanToInt("MMDXL"));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int romanToInt(String s) {
        int[] intNum = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanNum = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i = 0;  //扫描罗马数字
        int j = 0;  //扫描映射数组
        int rst = 0;    //存储结果整数
        while(i<s.length()){
            while(i<s.length() && j%2==0 && s.charAt(i)==romanNum[j].charAt(0)){
                rst += intNum[j];
                i++;
            }
            if(i<s.length()-1 && j%2==1 && s.charAt(i)==romanNum[j].charAt(0) && s.charAt(i+1)==romanNum[j].charAt(1)){
                rst += intNum[j];
                i += 2;
            }
            j++;
        }

        return rst;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
