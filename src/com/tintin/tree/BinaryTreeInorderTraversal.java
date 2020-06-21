package com.tintin.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Solution94 solution94 = new Solution94();
        System.out.println(solution94.inorderTraversal(tree.getRoot()));
        System.out.println(solution94.inorderTraversal2(tree.getRoot()));
    }
}

/**
 *  1、递归
 *   时间复杂度：O(n);遍历整棵树
 *   空间复杂度： O(log n);树的最大深度
 *
 *  2、使用栈
 *   时间复杂度：O(n);遍历整棵树
 *   空间复杂度： O(log n);树的最大深度
 */

class Solution94 {
    private List<Integer> list;

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);

        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        boolean turnRight = true;

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.peek();
            // 只有转向右子树后才需要重新将左子树压栈
            while (turnRight && treeNode.left != null) {
                stack.push(treeNode.left);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            list.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
                turnRight = true;
            }else {
                turnRight = false;
            }
        }

        return list;
    }

    public List < Integer > inorderTraversal22(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


}