//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串

  
  package com.tintin.leetcode.editor.cn;

import java.util.Scanner;

class ZigzagConversion{
      public static void main(String[] args) {
           Solution solution = new ZigzagConversion().new Solution();
           String s = "LEETCODEISHIRING";
           int num = 1;
//          Scanner in = new Scanner(System.in);
//          s = in.nextLine();
//          num = in.nextInt();
           String str = solution.convert(s,num);
           System.out.println(str);
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {

        if(s==null || s.length()<1)
            return "";
        if(numRows==1)
            return s;

        String str = "";
        int len = s.length();

        //二维字符数组初始化
        char[][] z_net = new char[numRows][(len+1)/2];
        for(int j=0;j<numRows;j++)
            for(int k=0;k<(len+1)/2;k++)
                z_net[j][k] = '0';

        int x=0,y=0;    //  字符坐标
        //按照要求填充二维数组
        for(int i=0;i<len;i++)
        {
            z_net[x][y] = s.charAt(i);
            if((i/(numRows-1))%2==0){   //向下
                x++;
            }
            if((i/(numRows-1))%2==1){   //向右上
                x--;
                y++;
            }
        }

        //二维字符数组遍历
        for(int j=0;j<numRows;j++)
            for(int k=0;k<(len+1)/2;k++)
            {
                if(z_net[j][k]!='0'){
                    str += z_net[j][k];
                }
            }

        return  str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
