package com.tintin.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(new Solution46().permute(null));
    }
}

class Solution46{
    private List<List<Integer>> lists;

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null){
            return lists;
        }
        lists = new ArrayList<>();
        int totalCount = 1;
        for(int i=2;i<=nums.length;i++){
            totalCount *= i;
        }
        backtrack(new ArrayList<>(),nums,totalCount);

        return lists;
    }

    public void backtrack(List<Integer> list,int[] nums,int totalCount){
        if(lists.size()==totalCount){
            return;
        }
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(list.contains(nums[j])){
                continue;
            }
            // 做选择
            list.add(nums[j]);
            backtrack(list,nums,totalCount);
            // 撤销选择
            list.remove((Integer)nums[j]);
        }
    }
}