package com.tintin.tree;

public class PathSum{
    public static void main(String[] args) {
        Tree tree = new Tree(new String[]{"5","4","8","11","null","13","4","7","2","null","null","null","1"});
        int sum = 22;
        System.out.println(new Solution112().hasPathSum(tree.getRoot(),sum));
    }
}

class Solution112{

    private int result = 0;
    private boolean flag = false;

    public boolean hasPathSum(TreeNode root,int sum){
        if(root==null){
            return flag;
        }
        preOrder(root,0,sum);
        return flag;
    }

    public void preOrder(TreeNode root,int curSum,int sum){
        if(flag){
            return;
        }
        curSum += root.val;
        if(root.left==null && root.right==null){
            if(curSum==sum){
                flag = true;
            }
            return;
        }
        if(root.left!=null){
            preOrder(root.left,curSum,sum);
        }
        if(root.right!=null){
            preOrder(root.right,curSum,sum);
        }
    }
}