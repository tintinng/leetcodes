package com.tintin.tree;

public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        System.out.println(new Solution104().maxDepth1(null));
    }
}

/**
 *  1、递归,左右子树中较大的深度+1；递归出口：为null则返回0；
 *    时间复杂度：O(n) 需要遍历整个树
 *    空间复杂度：O(log n) 需要保存的栈的大小为树的高度，最好是 O(log n),最差是 O(n)
 *
 *  2、使用 DFS或者 BFS访问每个结点，同时在每次访问时更新最大深度。
 */

class Solution104 {
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            return Integer.max(maxDepth1(root.right),maxDepth1(root.left)) + 1;
        }
    }
}