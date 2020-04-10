package com.tintin.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum{
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        Solution39 solution39 = new Solution39();
        System.out.println(solution39.combinationSum(candidates,target));
    }
}

class Solution39{
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,list,0,candidates,candidates.length,target);
        return lists;
    }

    private void backtrack(int i,List<Integer> list,int curSum,int[] candidates,int len,int target){
        if(curSum == target){
            // 注意需要新开辟一个arraylist
            lists.add(new ArrayList<>(list));
            return;
        }
        if(curSum > target){
            return;
        }
        for(int j=i;j<len;j++){
            //选择
            curSum += candidates[j];
            list.add(candidates[j]);
            //回溯
            backtrack(j,list,curSum,candidates,len,target);
            //撤销选择（注意remove Object和 remove index）
            list.remove((Integer) candidates[j]);
            curSum -= candidates[j];
        }
    }
}