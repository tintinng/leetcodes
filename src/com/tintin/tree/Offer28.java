package com.tintin.tree;

public class Offer28 {
    public static void main(String[] args) {
        TreeNode root = new Tree(new String[]{"1", "2", "2", "3", "null", "null", "3"}).getRoot();
        SolutionOffer28 solutionOffer28 = new SolutionOffer28();
        System.out.println(solutionOffer28.isSymmetric(root));
    }
}

class SolutionOffer28{
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricOf(root, root);
    }

    private boolean isSymmetricOf(TreeNode p1, TreeNode p2) {
        if (p1==null && p2==null) {
            return true;
        }
        if (p1 == null || p2 == null) {
            return false;
        }
        if (p1.val != p2.val) {
            return false;
        } else {
            return isSymmetricOf(p1.left, p2.right) && isSymmetricOf(p1.right, p2.left);
        }
    }
}
