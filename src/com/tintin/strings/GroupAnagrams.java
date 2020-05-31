package com.tintin.strings;

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {
        String[] strings = new String[]{
//                "eat", "tea", "tan", "ate", "nat", "bat"
                "ate", "nat", "bat"
        };
        Solution49 solution49 = new Solution49();
        System.out.println(solution49.groupAnagrams(strings));
    }
}

class Solution49{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Character,Integer> mapStr = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();
        // 一组anagrams str用map维护
        List<Map<Character,Integer>> maps = new ArrayList<>();
        if(strs.length==0){
            return lists;
        }
        for (String str:strs){
            for (int i=0;i<str.length();i++){
                mapStr.put(str.charAt(i),mapStr.getOrDefault(str.charAt(i),0)+1);
            }
            // 创建新的list加入进lists
//            if(!maps.contains(mapStr)){
//                maps.add(new HashMap<>(mapStr));
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                lists.add(list);
//            }
//            else {
//                // lists中找到str对应list并加入
//                for (List<String> li:lists) {
//                    if(isSameGroup(li.get(0),str)){
//                        li.add(str);
//                        break;
//                    }
//                }
//            }

            boolean flag = false;
            Iterator<List<String>> it = lists.iterator();
            while (it.hasNext()){
                List<String> li = it.next();
                if(isSameGroup(li.get(0),str)){
                    li.add(str);
                    flag = true;
                }
            }
            if(!flag){
                List<String> list = new ArrayList<>();
                list.add(str);
                lists.add(list);
            }

            mapStr.clear();
        }

        return lists;
    }

    /**
     * 判断两个str是否为同一组
     * @param str1
     * @param str2
     * @return
     */
    public boolean isSameGroup(String str1,String str2){
        Map<Character,Integer> mapStr1 = new HashMap<>();
        Map<Character,Integer> mapStr2 = new HashMap<>();
        for (int i=0;i<str1.length();i++){
            mapStr1.put(str1.charAt(i),mapStr1.getOrDefault(str1.charAt(i),0)+1);
        }
        for (int i=0;i<str2.length();i++){
            mapStr2.put(str2.charAt(i),mapStr2.getOrDefault(str2.charAt(i),0)+1);
        }
        return mapStr1.equals(mapStr2);
    }
}