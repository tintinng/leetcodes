package com.tintin.tree;

import java.util.*;

public class Offer32_3 {
    public static void main(String[] args) {
        TreeNode root = new Tree(new String[]{"3", "9", "20", "null", "null","15", "7"}).getRoot();
        SolutionOffer32_3 solutionOffer32_3 = new SolutionOffer32_3();
        System.out.println(solutionOffer32_3.levelOrder(root));
    }
}

/**
 *  分清奇偶层
 *      时间：O(n)
 *      空间：O(n)
 *   不一定得用reverse，效率较低。可以使用addfirst和addlast
 */
class SolutionOffer32_3{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 第一层是奇数层
        boolean isOdd = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
//            LinkedList<Integer> res = new LinkedList<>();
            int levelLength = queue.size();
            for (int i=0; i<levelLength; i++) {
                TreeNode node = queue.poll();
//                if (isOdd) {
//                    res.addFirst(node.val);
//                } else {
//                    res.addLast(node.val);
//                }
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 偶数层则反转数组
            if (!isOdd) {
                Collections.reverse(list);
            }
            lists.add(list);
//            lists.add(res);
            // 奇数层下一层是偶数层，偶数层下一层是奇数层
            isOdd = !isOdd;
        }

        return lists;
    }
}
