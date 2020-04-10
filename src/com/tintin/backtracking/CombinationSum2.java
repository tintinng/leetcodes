package com.tintin.backtracking;

import java.util.*;

public class CombinationSum2{
    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(new Solution40().combinationSum2(new int[]{1},1));
    }
}

class  Solution40{
    private List<List<Integer>> lists;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
//        // 去重
//        Set<Integer> set = new HashSet<>();
//        for (int cadidate : candidates){
//            set.add(cadidate);
//        }
//        //排序
//        Set<Integer> treeSet = new TreeSet<>(set);
//        //转为包装类数组
//        Integer[] integers = treeSet.toArray(new Integer[]{});
//        //转为int数组
//        int[] cans = new int[integers.length];
//        for (int i=0;i<integers.length;i++){
//            cans[i] = integers[i];
//        }

        if(candidates==null || candidates.length==0){
            return lists;
        }
        backtrack(0,list,0,candidates,candidates.length,target);

        return lists;
    }

    private void backtrack(int i,List<Integer> list,int curSum,int[] candidates,int len,int target){
        if(curSum == target){
            //去重
//            Collections.sort(list);
//            if(!lists.contains(list)){
//                lists.add(new ArrayList<>(list));
//            }
//            return;

            lists.add(new ArrayList<>(list));
            return;
        }
        // 结束条件 || 剪枝
        if(i==len || curSum>target){
            return;
        }

        for(int j=i;j<len;j++){
            //做选择
            curSum += candidates[j];
            list.add(candidates[j]);

            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }

            backtrack(j+1,list,curSum,candidates,len,target);
            //撤销选择
            list.remove((Integer)candidates[j]);
            curSum -= candidates[j];
        }
    }
}