package com.tintin.tree;

import java.util.HashMap;

public class Offer07 {
    public static void main(String[] args) {

    }
}

/**
 *  1、递归
 */

class SolutionClass07 {

    private int[] preOrder;
    private int[] inOrder;

    // 建立中序遍历中数组元素和下标的一一对应

    private HashMap<Integer,Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inOrder[i],i);
        }

        return null;
    }

    /**
     *
     * @param preRoot   根节点在前序遍历中的索引
     * @param inLeft    当前树在中序遍历中的左边界
     * @param inRight   当前树在中序遍历中的右边界
     * @return  当前树根节点
     */
    private TreeNode recur(int preRoot,int inLeft,int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preRoot]);

        root.left = recur(preRoot+1, inLeft, map.get(preOrder[preRoot])-1);
        root.right = recur(map.get(preOrder[preRoot])-inLeft + preRoot + 1, map.get(preOrder[preRoot])+1, inRight);

        return root;
    }
}
