package com.tintin.strings;

public class AddStrings{
    public static void main(String[] args) {
        Solution415 solution415 = new Solution415();
        String num1 = "123";
        String num2 = "98954";
        System.out.println(solution415.addStrings("",""));
    }
}

class Solution415{
    // 关键在于边界
    public String addStrings(String num1, String num2) {
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
