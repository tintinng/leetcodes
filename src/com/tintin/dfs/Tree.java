package com.tintin.dfs;

import java.util.HashMap;
import java.util.Map;

public class Tree {
    private TreeNode root;

    public Tree() {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(3);
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t3.left = t6;
//        t3.right = t7;
//        t6.left = t8;
        root = t1;
    }

    // 字符串数组 转换为 二叉树
    public Tree(String[] nums){
        TreeNode curParent = new TreeNode(Integer.parseInt(nums[0]));
        // 使用map存储数组下标和treenode的对应
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(0,curParent);
        root = curParent;
        for(int i=0;i<nums.length;i++){
            curParent = map.get(i);
            if((i+1)*2-1<nums.length && !"null".equals(nums[(i+1)*2-1])){
                curParent.left = new TreeNode(Integer.parseInt(nums[(i+1)*2-1]));
                map.put((i+1)*2-1,curParent.left);
            }
            if((i+1)*2<nums.length && !"null".equals(nums[(i+1)*2])){
                curParent.right = new TreeNode(Integer.parseInt(nums[(i+1)*2]));
                map.put((i+1)*2,curParent.right);
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}
