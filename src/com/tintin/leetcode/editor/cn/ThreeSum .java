//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三
//元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

  
  package com.tintin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
          int[] nums = new int[]{};
          System.out.println(solution.threeSum(nums));
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++)  //第一个加数
        {
            int l=i+1,r=nums.length-1;
            while(l<r){ //两个加数从两端往中间测试
                if(nums[i]+nums[l]+nums[r] < 0){
                    l++;
                }
                else if(nums[i]+nums[l]+nums[r] > 0){
                    r--;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    if(!lists.contains(list))   //去除重复元素
                        lists.add(list);
                    l++;
                    r--;
                }
            }
        }

        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
