package com.tintin.arrayandcollection;

public class ContainerWithMostWater{
    public static void main(String[] args) {
        int[] height = new int[]{1,8};
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(height));
    }
}

class Solution11{
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        // 双指针：两块板子往中间移动
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            // 当前板子容量
            int curArea = (j-i) * (Integer.min(height[i],height[j]));
            maxArea = Integer.max(curArea,maxArea);
            // 移动高度较低的板子
            if (height[i] > height[j]) {
                j--;
            }else {
                i++;
            }
        }

        return maxArea;
    }
}
