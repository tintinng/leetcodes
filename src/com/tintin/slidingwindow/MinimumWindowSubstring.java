package com.tintin.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring{
    public static void main(String[] args) {
        String s = "bbaa";
        String t = "aba";
        Solution76 solution76 = new Solution76();
        System.out.println(solution76.minWindow(s,t));
    }
}

class Solution76{
    public String minWindow(String s, String t) {
        if("".equals(s) || "".equals(t)){
            return "";
        }
        if(s.length()<t.length()){
            return "";
        }
        if(s.equals(t)){
            return t;
        }
        int left = 0;
        int right = 0;
        // 保存minWindow的左右指针
        int minLeft = 0;
        int minRight = s.length();

        // 用hashmap中的key来存放当前窗口字符，value存放当前窗口包含该字符的个数
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
        // 用hashmap中的key来存放t中的字符，value存放当前窗口包含该字符的个数
        HashMap<Character,Integer> tMap = new HashMap<Character, Integer>();
        for (int i=0;i<t.length();i++) {
            if (!tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), 1);
            } else {
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            }
        }
        while(left<s.length()){
            int i = 0;
            for (;i<t.length();i++){
                // t中第i个字符在当前窗口中不存在
                if (!hashMap.containsKey(t.charAt(i))){
                    break;
                }
                // t中第i个字符和当前窗口中t.charAt(i)数量不一致
                if(hashMap.get(t.charAt(i)) < tMap.get(t.charAt(i))){
                    break;
                }
            }
            // 找到一个包含t中所有字符的string,左指针右移优化
            if(i==t.length()){
                // 更新minWindow
                if((right-left) <= (minRight-minLeft)){
                    minLeft = left;
                    minRight = right;
                }
                int value;
                // 存放多于一个s.charAt(left)
                if(hashMap.containsKey(s.charAt(left)) && (value = hashMap.get(s.charAt(left)))>1){
                    hashMap.put(s.charAt(left),value-1);
                }
                else {
                    hashMap.remove(s.charAt(left));
                }
                left++;
            }
            // 没有找到一个包含t中所有字符的string，右指针右移继续找
            else{
                if(right==s.length()){
                    break;
                }
                // 存在s.charAt(right)
                if(hashMap.containsKey(s.charAt(right))){
                    hashMap.put(s.charAt(right), hashMap.get(s.charAt(right)) +1);
                }
                else {
                    hashMap.put(s.charAt(right),1);
                }
                right++;
            }
        }

        // 不存在
        if(s.substring(minLeft,minRight).equals(s) && left==0){
            return "";
        }

        return s.substring(minLeft,minRight);
    }
}
