package com.tintin.arrayandcollection;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        Solution78 solution78 = new Solution78();
        System.out.println(solution78.subsets1(nums));
    }
}

/**
 *  1、迭代: 遍历所有元素，将元素加入list后，取已存在的list加入元素
 *    时间复杂度：O(N * 2^N)
 *    空间复杂度：O(N * 2^N)
 *  2、递归回溯 (回溯思路：当前元素在或者不在)
 *    时间复杂度：O(N * 2^N)
 *    空间复杂度：O(N * 2^N)
 */

class Solution78 {

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        lists.add(new ArrayList<>());

        for (int num : nums) {

            List<List<Integer>> curList = new ArrayList<>(lists);

            for (List<Integer> integers : curList) {
                List<Integer> list = new ArrayList<>(integers);
                list.add(num);
                lists.add(list);
            }
        }

        return lists;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}