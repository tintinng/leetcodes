package com.tintin.backtracking;

import java.util.*;

public class Offer38 {
    public static void main(String[] args) {
        String str = new String("aab");
        SolutionOffer38 solutionOffer38 = new SolutionOffer38();
        System.out.println(Arrays.toString(solutionOffer38.permutation(str)));
    }
}

class SolutionOffer38 {
//    private String[] strs;
    private List<String> strList;
    private HashSet<String> hashSet;
    private int k = 0;

    public String[] permutation(String s) {
        // 全排列最大的字符数组长度
//        int maxLength = 1;
//        for (int j=1; j<=s.length(); j++) {
//            maxLength *= j;
//        }
//        strs = new String[maxLength];
        strList = new LinkedList<>();
        hashSet = new HashSet<>();
        StringBuilder sb = new StringBuilder("");
        List<Integer> chosen = new ArrayList<>();
        recur(sb, s, chosen);

        return strList.toArray(new String[]{});
    }

    private void recur(StringBuilder sb, String s, List<Integer> chosen) {
        if (sb.length() == s.length()) {
            // 检测是否包含重复字符串
            if (!hashSet.contains(sb.toString())) {
                hashSet.add(sb.toString());
//                strs[k++] = sb.toString();
                strList.add(sb.toString());
            }
            return;
        }
        for (int i=0; i<s.length(); i++) {
            if (chosen.contains(i)) {
                continue;
            }
            sb.append(s.charAt(i));
            chosen.add(i);
            recur(sb, s, chosen);
            chosen.remove(new Integer(i));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
