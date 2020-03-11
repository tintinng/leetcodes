//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组

  
  package com.tintin.leetcode.editor.cn;
  class NextPermutation{
      public static void main(String[] args) {
          int[] nums = new int[]{5,3,3};
          Solution solution = new NextPermutation().new Solution();
          solution.nextPermutation(nums);
          for(int i=0;i<nums.length-1;i++){
              System.out.print(nums[i]+",");
          }
          System.out.println(nums[nums.length-1]);
      }

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return;
        }
        //1、找到最低的改变位数i，大于i的为低位，小于i的为高位
        int i = nums.length-2;
        int end = nums.length-1;
        while(nums[i]>=nums[i+1]){
            i--;
            if(i==-1){
                break;
            }
        }
        //2、若i找到不是-1，
        if(i>=0){
            //则找低位中大于num[i]且大小和num[i]最接近的数num[j];
            int j=nums.length-1;
            while(j>i){
                if(nums[j]>nums[i]){
                    break;
                }
                j--;
            }
            //3、num[i]和num[j]互换
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        //2、若找到是-1则直接逆置
        reverse(nums,i+1,nums.length-1);
    }

    public void reverse(int[] nums,int head,int tail){
        while (head<tail){
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            head++;
            tail--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
