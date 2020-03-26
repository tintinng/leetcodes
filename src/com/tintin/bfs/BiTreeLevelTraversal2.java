package com.tintin.bfs;

import java.util.*;

public class BiTreeLevelTraversal2{
    public static void main(String[] args) {
        Tree tree = new Tree();
        Soletion107 soletion107 = new Soletion107();
        System.out.println(soletion107.solute(tree.getRoot()));

    }
}

class Soletion107{
    public List<List<Integer>> solute(TreeNode root){
        //1、从上到下、从左到右层次遍历
        //2、遍历结果存入List
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if(root==null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            //队列元素即为一层的节点元素
            int levelNums = queue.size();
            //记录一层的list
            List<Integer> list = new ArrayList<Integer>();
            lists.add(list);
            //遍历一层
            for(int i=0;i<levelNums;i++){
                TreeNode head = queue.poll();
                if(head!=null) {
                    lists.get(level).add(head.val);
                    if(head.left!=null){
                        queue.offer(head.left);
                    }
                    if(head.right!=null){
                        queue.offer(head.right);
                    }
                }
            }
            //进入下一层
            level++;
        }
        //3、List逆置
        Collections.reverse(lists);

        return lists;
    }
}

