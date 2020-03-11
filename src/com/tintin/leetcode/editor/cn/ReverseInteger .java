//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学

  
  package com.tintin.leetcode.editor.cn;
  class ReverseInteger{
      public static void main(String[] args) {
           Solution solution = new ReverseInteger().new Solution();
          int rst = solution.reverse(-2147483648);
           System.out.println(rst);
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int result = 0;
        int c;
        boolean flag = true;

        if(x == (-x))
            return 0;

        if(x < 0){  //负数变成正数
            x = -x;
            flag = false;
        }

        while(x%10 == 0){   //去掉结尾的0
            x = x/10;
        }

        do {    //反转
            c = x%10;
            result = result*10 + c;
            x = x/10;
        }while(x/10 != 0);
        if(x!=0){
            if(result<=(Integer.MAX_VALUE-x)/10){
                result = result*10 + x;
            }
            else{
                result = 0;
            }
        }


        if(!flag)
            result = -result;

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
