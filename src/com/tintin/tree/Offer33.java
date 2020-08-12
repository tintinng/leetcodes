package com.tintin.tree;

public class Offer33 {
    public static void main(String[] args) {
        SolutionOffer33 solutionOffer33 = new SolutionOffer33();
        int[] postorder = new int[]{4, 8, 6, 12, 16, 14, 10};
        System.out.println(solutionOffer33.verifyPostorder(postorder));
    }
}

/**
 *  1、找到根结点（数组最后一个元素），除去根节点剩下为左右子树
 *     假定是二叉搜索树的后序遍历，则可以找到数组中第一个比根节点元素大的树。左边即为左子树，右边即为右子树
 *      时间：O(n*n)
 *      空间：O(n)
 *  2、单调栈
 */
class SolutionOffer33 {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return recurVerify(postorder, 0, postorder.length-1);
    }

    /**
     *
     * @param postoer 后序遍历数组
     * @param start 子树的后序遍历左边界
     * @param end 子树的后序遍历右边界
     * @return
     */
    public boolean recurVerify(int[] postoer, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postoer[end];
        int rightRoot = end;
        // 找到右子树的根节点
        for (int i=start; i<end; i++) {
            if (postoer[i] > root) {
                rightRoot = i;
                break;
            }
        }
        // 若右子树中还有比根节点大的数，则无法构成搜索二叉树
        for (int i=rightRoot; i<end; i++) {
            if (postoer[i] < root) {
                return false;
            }
        }

        return recurVerify(postoer, 0, rightRoot-1) && recurVerify(postoer, rightRoot, end-1);
    }
}
