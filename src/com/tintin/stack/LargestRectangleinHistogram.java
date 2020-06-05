package com.tintin.stack;

import java.util.Map;
import java.util.Stack;

public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        int[] heights = new int[]{3,3,3,6,7,8,9};
        Solution84 solution84 = new Solution84();
        System.out.println(solution84.largestRectangleArea(heights));
    }
}

class Solution84 {
    // 遍历每一个bar，找到左边界和右边界，计算以当前bar为高度的面积并和maxArea比较
    public int largestRectangleArea(int[] heights) {
        // 用一个栈来维护左边界,大小为2的数组，第一个元素是index，第二个元素是value；栈中的value保持有序
        Stack<int[]> stack = new Stack<>();
        // bar的最小高度为0，可用-1来表示左边界在最左边
        stack.push(new int[]{-1,-1});
        int maxArea = 0;
        int leftBar;
        int rightBar;
        for (int i=0; i<=heights.length; i++) {
            if (i!=heights.length && stack.peek()[1] <= heights[i]) {
                stack.push(new int[]{i,heights[i]});
            }else {
                // 找到右边界，栈顶元素为当前bar；找到当前bar高度
                int curBarHeight = stack.pop()[1];
                if (curBarHeight == -1) {
                    break;
                }
                // 由于栈内有序，当前bar上一个即为当前bar左边界，以当前bar为高度的最大宽度
                int curBreath = i - stack.peek()[0] - 1;
                maxArea = Integer.max(curBarHeight*curBreath, maxArea);
                // 重新判断此bar是否为栈内bar的右边界
                i--;
            }
        }

        return maxArea;
    }
}