package com.tintin.tree;

public class Offer27 {
    public static void main(String[] args) {
        TreeNode root = new Tree(new String[]{}).getRoot();
        SolutionOffer27 solutionOffer27 = new SolutionOffer27();
        TreeNode newRoot = solutionOffer27.mirrorTree(root);
        System.out.println("ok");
    }
}

/**
 *  1、递归，镜像后的左子树实际上是右子树的镜像，镜像后的右子树是左子树的镜像
 *      时间：O(n) 遍历整棵树
 *      空间：O(n) 递归深度,最差情况下退化为链表
 */
class SolutionOffer27{
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }
}
