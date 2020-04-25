package com.tintin.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree{
    public static void main(String[] args) {
        TreeNode root = new Tree().getRoot();
        Solution101 solution101 = new Solution101();
        System.out.println(solution101.isSymmetric(root));
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        this.val = x;
    }
}

class Solution101{
    /**
     * 从每一层的两头向中间遍历
     * 关键在于将根节点如何处理root\root连入两次栈
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return false;
        }
        boolean flag = true;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(root);
        while(queue.size()>=2){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1.val != node2.val){
                flag = false;
                break;
            }
            if(node1.left!=null || node2.right!=null){
                if(node1.left!=null && node2.right!=null){
                    queue.add(node1.left);
                    queue.add(node2.right);
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(node1.right!=null || node2.left!=null){
                if(node1.right!=null && node2.left!=null){
                    queue.add(node1.right);
                    queue.add(node2.left);
                }
                else{
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

    /**
     * 官方题解
     * @param root
     * @return
     */
    public boolean isSymmetric0(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}