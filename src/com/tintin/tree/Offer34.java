package com.tintin.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer34 {
    public static void main(String[] args) {
        SolutionOffer34 solutionOffer34 = new SolutionOffer34();
        TreeNode root = new Tree(new String[]{"5", "4", "8", "11", "null", "13", "4", "7", "2", "null",
                "null", "null", "null", "5", "1"}).getRoot();
        System.out.println(solutionOffer34.pathSum(null, 22));
    }
}

/**
 *  1、回溯
 *      时间：O(n)
 *      空间：O(n)
 *  (注意：插入删除元素较多时要使用LinkedList)
 *
 */
class SolutionOffer34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        list.add(root);

        recur(lists, root, list, 0, sum);

        return lists;
    }

    private void recur(List<List<Integer>> lists, TreeNode node, List<TreeNode> path, int pathSum, int sum) {
        pathSum += node.val;
        // 剪枝 (如果包含负数则不能剪枝)
        if (pathSum > sum) {
            return;
        }
        // 找到一条路径，加入lists
        if (pathSum == sum && node.left == null && node.right == null) {
            List<Integer> list = new ArrayList<>();
            for (TreeNode n:path) {
                list.add(n.val);
            }
            lists.add(list);
        }
        // 回溯左子树
        if (node.left != null) {
            path.add(node.left);
            recur(lists, node.left, path, pathSum, sum);
            path.remove(node.left);
        }
        // 回溯右子树
        if (node.right != null) {
            path.add(node.right);
            recur(lists, node.right, path, pathSum, sum);
            path.remove(node.right);
        }
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }

}
