//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针

  
  package com.tintin.leetcode.editor.cn;

import java.util.Arrays;

class ThreeSumClosest{
      public static void main(String[] args) {
           Solution solution = new ThreeSumClosest().new Solution();

          int[] sums = new int[]{1,2,4,8,16,32,64,128};
          int target = 82;
          System.out.println(solution.threeSumClosest(sums,target));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closesttNum = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            int l=i+1,r=nums.length-1;
            while(l<r){
                int temp = nums[i]+nums[l]+nums[r];
                closesttNum = Math.abs(temp-target)>Math.abs(closesttNum-target) ? closesttNum:temp;//取closest num
                if(temp < target){
                    l++;
                }
                else if(temp > target){
                    r--;
                }
                else{
                    return closesttNum;
                }
            }
        }

        return closesttNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
