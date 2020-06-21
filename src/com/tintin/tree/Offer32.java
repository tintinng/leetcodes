package com.tintin.tree;

import java.util.*;

public class Offer32 {
    public static void main(String[] args) {
        Tree tree = new Tree(new String[]{"3","9","20","null","null","15","7"});
        SolutionOffer32 solutionOffer32 = new SolutionOffer32();
        System.out.println(Arrays.toString(solutionOffer32.levelOrder(tree.getRoot())));

    }
}

/**
 *  1、树的层次遍历，用队列
 */

class SolutionOffer32 {
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            list.add(top.val);
            if (top.left != null) {
                queue.offer(top.left);
            }
            if (top.right != null) {
                queue.offer(top.right);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}