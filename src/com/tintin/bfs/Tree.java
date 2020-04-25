package com.tintin.bfs;

public class Tree{
    private TreeNode root;

    public Tree() {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(7);
//        t1.left = t2;
//        t1.right = t3;
//        t3.left = t4;
//        t3.right = t5;
//        t2.right = t6;
        root = t1;
    }

    public TreeNode getRoot() {
        return root;
    }
}
