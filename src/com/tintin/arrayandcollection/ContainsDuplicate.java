package com.tintin.arrayandcollection;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate{
    public static void main(String[] args) {
        int[] nums = new int[]{};
        Solution217 solution217 = new Solution217();
        System.out.println(solution217.containsDuplicate(nums));
    }
}

class Solution217{
    public boolean containsDuplicate(int[] nums) {
        if(nums.length==0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 1);
        }

        return false;
    }
}