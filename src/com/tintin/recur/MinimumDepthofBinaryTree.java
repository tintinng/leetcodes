package com.tintin.recur;


public class MinimumDepthofBinaryTree{
    public static void main(String[] args) {
        TreeNode root = new Tree().getRoot();
        System.out.println(new Solution111().minDepth(null));
    }
}

class Solution111{
    //递归
    public int minDepth(TreeNode root) {
        // 递归出口
        if(root==null){
            return 0;
        }
        // 左子树为空
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        // 右子树为空
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        // 左右子树都不为空
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}