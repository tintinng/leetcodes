//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找

  
  package com.tintin.leetcode.editor.cn;
  class SearchInRotatedSortedArray{
      public static void main(String[] args) {
          int[] nums = new int[]{3,1};
           Solution solution = new SearchInRotatedSortedArray().new Solution();
          System.out.println(solution.search(nums,1));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int rst = -1;
        if(nums.length==0){
            return  -1;
        }
        //1、用二分查找确定旋转的中心点
        int i=0;
        do{
            //找到目标值就退出
            if(nums[i]==target){
                rst = i;
                return rst;
            }
            i++;
        }while(i<nums.length && nums[i-1]<nums[i]);
        //没找到中心点,也没找到目标值
        if(i==nums.length){
            return -1;
        }
        //2、在中心点右边进行二分查找
        int left = i;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                rst = mid;
                break;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }


        return rst;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
