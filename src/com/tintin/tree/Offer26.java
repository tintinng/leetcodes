package com.tintin.tree;

public class Offer26 {
    public static void main(String[] args) {
    }
}

/**
 *  1、遍历树 A，测试以每一个节点为根节点的树
 *      时间：O(n*m)
 *      空间：O(n),递归的深度
 */
class SolutionOffer26{
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean flag = false;
        if (A==null || B==null) {
            return flag;
        }else {
            return test(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    /**
     * 判断B中以b节点为根节点的树 是否是 以A中以 a节点为根节点的树的子结构
     *
     */
    private boolean test(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return test(a.left, b.left) && test(a.right, b.right);
    }
}
