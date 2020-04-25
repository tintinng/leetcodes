package com.tintin.backtracking;

import java.util.*;

public class Permutations2{
    public static void main(String[] args) {
        int nums[] = new int[]{2,2,1,1};
        Solution47 solution47 = new Solution47();
        System.out.println(solution47.permuteUnique(nums));
    }
}

class Solution47{
    private List<List<Integer>> lists;

    public List<List<Integer>> permuteUnique(int[] nums){
        lists = new ArrayList<>();
        if(nums.length==0){
            return lists;
        }
        Arrays.sort(nums);
        Boolean[] used = new Boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            used[i] = false;
        }
        backtrack(-1,used,new LinkedList<>(),nums,nums.length);

        return lists;
    }

    private void backtrack(int i, Boolean[] used,LinkedList<Integer> list, int[] nums, int len){
        // 结束条件
        if(list.size()==len){
            if(!lists.contains(list)){
                lists.add(new LinkedList<>(list));
            }
            return;
        }
        for(int j=0;j<len;j++){
            if(used[j]){
                continue;
            }
            // 剪枝
            if(j>0 && nums[j]==nums[j-1] && !used[j-1]){
                continue;
            }
            //做选择
            used[j] = true;
            list.add(nums[j]);
            //回溯
            backtrack(j,used,list,nums,len);
            //撤销选择
            list.removeLastOccurrence((Integer) nums[j]);
            used[j] = false;
        }
    }

}
