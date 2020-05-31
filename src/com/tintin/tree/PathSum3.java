package com.tintin.tree;

public class PathSum3{
    public static void main(String[] args) {
        Tree tree = new Tree(new String[]{"10","5","-3","3","2","null","11","3","-2","null","1"});
    }
}

class Solution437{

    private int result = 0;

    /**
     * f[n] 表示从root到节点n的path包含的满足条件的path数
     * f[n] = f[n-1] + 以n结尾的满足条件的 path数
     *
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root,int sum){
        int result = 0;
        return result;
    }

    public void preOrder(){}
}
