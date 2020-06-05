package com.tintin.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = new String("wq");
        String t = new String("qw");
        System.out.println(new Solution242().isAnagram(s,t));
    }
}

class Solution242 {
    public boolean isAnagram(String s, String t) {
        int strLen = s.length();
        if (strLen != t.length()) {
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();

        for (int i=0; i<strLen; i++) {
            int value = map.getOrDefault(s.charAt(i),0) + 1;
            map.put(s.charAt(i),value);
        }

        for (int i=0; i<strLen; i++) {
            int val = map.getOrDefault(t.charAt(i),0) - 1;
            if (val <= 0) {
                map.remove(t.charAt(i));
            }else {
                map.put(t.charAt(i),val);
            }
        }

        return map.isEmpty();
    }

    public boolean isAnagram2(String s, String t) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        char[] b = t.toCharArray();
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
}