package com.tintin.twopoint;

public class ImplementstrStr{
    public static void main(String[] args) {
        String haystack = "aaaaabba";
        String needle = "bba";
        System.out.println(new Solution28().strStr(haystack,needle));
    }
}

class Solution28{
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null){
            return -1;
        }
        if(needle.isEmpty()){
            return 0;
        }
        int i = 0;
        int j = needle.length()-1;
        while (j<haystack.length()){
            int k = 0;
            for(;k<=j-i;k++){
                if(haystack.charAt(i+k) != needle.charAt(k)){
                    break;
                }
            }
            if(k>j-i){
                return i;
            }
            i++;
            j++;
        }

        return -1;
    }
}
