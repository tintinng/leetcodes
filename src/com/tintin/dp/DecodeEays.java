package com.tintin.dp;

public class DecodeEays{
    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        String str = "01";
        System.out.println(solution91.numDecodings(str));
    }
}

class Solution91{
    /**
     * leetcode题目需求不明确
     * @param s
     * @return
     */
    public int numDecodings(String s){
        //1、确定数组 f[i]表示以 第i+1个字符结尾的字符串包含的 decode组合数
        //2、则转移方程为：f[i] = f[i-1] + (Integer.parseInt(s.substring(i-1,i)) > 26 ? 0 : 1)
        //3、边界：f[0]=1;输入为0的转移方程会变化
        //4、for填满数组,f[i]即为结果

        int len = s.length();
        if(s==null || s.isEmpty()){
            return 0;
        }
        int f[] = new int[len];
        int j = 0;
        //去掉首部的0
        while (j<len){
            if('0'==(s.charAt(j))){
                j++;
            }
            else {
                if(j==len-1){
                    return 1;
                }else {
                    f[j] = 1;
                    break;
                }
            }
        }
        //j为第一个非0数字
        for(int i=j+1;i<len;++i){
            //和上一个字符组合若可decode，则addNum为 1
            int addNum = Integer.parseInt(s.substring(i-1,i+1)) > 26 ? 0 : 1;
            //当前字符为 0不可decode
            if('0'==(s.charAt(i))){
                //和上一个字符组合可以decode
                if(addNum==1){
                    if(i-j<2){
                        f[i] = 1;
                    }
                    else {
                        f[i] = f[i-2];
                    }
                }
                //和上一个字符组合不可decode
                else{
                    f[i] = f[i-1];
                }
            }
            //当前数字为 1-9可以decode
            else {
                f[i] = f[i-1] + addNum;
            }
        }

        return f[len-1];
    }
}
