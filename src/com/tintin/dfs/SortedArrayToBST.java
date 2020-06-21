package com.tintin.dfs;




public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        Solution108 solution108 = new Solution108();
        TreeNode treeNode = solution108.sortedArrayToBST(nums);
        System.out.println(treeNode.val);
    }
}

/**
 *  1、递归中序遍历，从中间分开，数组两边又是两个新的BST，分别对应左子树和右子树
 *   时间：O(N)
 *   空间：O(N)
 */

class Solution108 {

    private int[] nums;

    public TreeNode inorder(int left,int right) {

        if (left > right) {
            return null;
        }

        int rootIndex = (left + right)/2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = inorder(left,rootIndex-1);
        root.right = inorder(rootIndex+1,right);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return inorder(0,nums.length-1);
    }
}
