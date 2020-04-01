package com.tintin.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber{
    public static void main(String[] args) {
        String digits = "";
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations(digits));
    }
}

class Solution17{
    // 结果集
    private List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty() || digits==null){
            return list;
        }
        Map<Character,String> digitStrMapper = new HashMap<>(8);
        digitStrMapper.put('2',"abc");
        digitStrMapper.put('3',"def");
        digitStrMapper.put('4',"ghi");
        digitStrMapper.put('5',"jkl");
        digitStrMapper.put('6',"mno");
        digitStrMapper.put('7',"pqrs");
        digitStrMapper.put('8',"tuv");
        digitStrMapper.put('9',"wxyz");

        backtrack(0,new StringBuilder(),digitStrMapper,digits,digits.length());
        return list;
    }

    /**
     *
     * @param dIndex:digit中的当前数字
     * @param s:当前组合字符，若达到最大长度则加入list中
     * @param digitStrMapper:数字-字符串的映射
     * @param digits:数字串
     * @param digitsLen:数字串的长度
     */
    private void backtrack(int dIndex,StringBuilder s,
                           Map<Character,String> digitStrMapper,String digits,int digitsLen){
        // 当前组合字符s已经达到最大长度
        if(dIndex==digitsLen){
            list.add(s.toString());
            return;
        }
        // 获取当前数字映射的字符串(选择列表)
        String mappingStr = digitStrMapper.get(digits.charAt(dIndex));
        for (int j=0;j<mappingStr.length();j++){
            // 做选择，加入char
            s.append(mappingStr.charAt(j));
            //回溯
            backtrack(dIndex+1,s,digitStrMapper,digits,digitsLen);
            // 撤销选择
            s.deleteCharAt(dIndex);
        }
    }
}