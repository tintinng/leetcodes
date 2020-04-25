package com.tintin.tree;

public class SumOfLeftLeaves{
    public static void main(String[] args) {
        Tree tree = new Tree();
        System.out.println(new Solution404().sumOfLeftLeaves(tree.getRoot()));
    }
}

class Solution404{

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root){

        if(root!=null){
            // 根节点不算左子树部分
            preOrder(root,false);
        }

        return sum;
    }

    /**
     *  递归
     * @param root
     * @param isLeft 用一个布尔值isLeft做标记
     */
    public void preOrder(TreeNode root,Boolean isLeft){
        if(root.left==null && root.right==null && isLeft){
            sum += root.val;
            return;
        }
        if(root.left!=null){
            preOrder(root.left,true);
        }
        if(root.right!=null){
            preOrder(root.right,false);
        }
    }
}