package com.tintin.strings;

public class Offer05 {
    public static void main(String[] args) {
        String s = new String("We are happy. ");
        SolutionOffer05 solutionOffer05 = new SolutionOffer05();
        System.out.println(solutionOffer05.replaceSpace(s));
    }
}

/**
 *  1、使用 StringBuilder ，扫描一遍原字符串,给StringBuilder添加上
 *     时间：O(N)
 *     空间：O(N)
 *  2、在原字符串上修改，并且保证足够内存。可以使用双指针从后往前 “merge”
 */

class SolutionOffer05 {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}