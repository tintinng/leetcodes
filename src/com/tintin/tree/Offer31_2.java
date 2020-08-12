package com.tintin.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer31_2 {
    public static void main(String[] args) {

    }
}

class SolutionOffer31_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int curLen = queue.size();
            // 当前层循环
            for (int i=0; i<curLen; i++) {
                TreeNode treeNode = queue.poll();
                curList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            lists.add(curList);
        }

        return lists;
    }
}

// 是第 k层的结点，就向第 k个list添加val
class Solution0 {
    List<List<Integer>> node=new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        lei(root,0);
        return node;
    }
    public void lei(TreeNode root,int k){
        if(root!=null){
            if(node.size()<=k) {
                node.add(new ArrayList());
            }
            // 是第 k层的结点，就向第 k个list添加val
            node.get(k).add(root.val);
            lei(root.left,k+1);
            lei(root.right,k+1);
        }
    }
}
