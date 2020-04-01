package com.tintin.slidingwindow;

public class LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
        String string = new String("ABEGACCDEFG");
        System.out.println(new Solution424().characterReplacement2(string,2));
    }
}

class Solution424{
    private int[] map = new int[26];

    /**
     * 滑动窗口问题，当k=0时即为最长连续子串问题
     * 限定字符串只能由大写字母组成，考虑用count[]记下滑动窗口包含的各个字母个数
     * 并记下当前窗口包含最多的字母 maxChar
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k){
        if(s.isEmpty() || s==null){
            return 0;
        }

        int left = 0;
        int right = 0;
        char maxChar = s.charAt(0);
        int[] count = new int[26];
        while(right<s.length()){
            count[s.charAt(right)-'A']++;
            // 遇到可连续字符
            if(s.charAt(right) == maxChar){
                right++;
            }
            // 遇到不可连续字符
            else{
                // 判断新加入的字符数量和最大字符数量
                if(count[s.charAt(right)-'A'] > count[maxChar-'A']){
                    maxChar = s.charAt(right);
                }
                // 当前窗口字符串通过k次补充后可以形成连续字符串
                if(count[maxChar-'A'] + k >= right - left + 1){
                    right++;
                }
                // 否则直接平移
                else {
                    count[s.charAt(left)-'A']--;
                    left++;
                }
            }
        }

        return s.length()-left;
    }
    public int characterReplacement2(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        // 理解一下charMax这个变量，并不是代表当前窗口最多的重复字符个数
        int charMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            charMax = Math.max(charMax, map[index]);
            // 当前字符串不可以形成连续字符
            if (right - left + 1 > charMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}
