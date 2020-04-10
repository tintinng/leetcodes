package com.tintin.strings;

public class MultiplyStrings{
    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "9";
        System.out.println(new Solution43().multiply(num1,num2));
    }
}

class Solution43{
    public String multiply(String num1, String num2) {
        if(num1.isEmpty() || num2.isEmpty()){
            return "";
        }
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int i = num1.length()-1;
        int j = num2.length()-1;

        String preStr = "0";

        for(;j>=0;j--){
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for(i = num1.length()-1;i>=0;i--){
                int factor1 = num1.charAt(i) - '0';
                int factor2 = num2.charAt(j) - '0';
                int temp = factor1*factor2 + carry;

                carry = temp / 10;
                sb.append((char)('0'+temp%10));
            }
            if(carry!=0){
                sb.append((char)('0'+carry));
            }
            sb.reverse();
            int k = 0;
            while(k<num2.length()-j-1){
                sb.append('0');
                k++;
            }
            preStr = add(preStr,sb.toString());
        }

        return preStr;
    }

    private String add(String num1, String num2){
        StringBuilder stringBuilder = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        while (i>=0 || j>=0){
            int n1 = i>=0 ? num1.charAt(i)-'0' : 0;
            int n2 = j>=0 ? num2.charAt(j)-'0' : 0;
            int temp = n1 + n2 + carry;
            stringBuilder.append((char) ('0'+temp%10));
            carry = temp/10;
            i--;
            j--;
        }
        if (carry!=0){
            stringBuilder.append('1');
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
