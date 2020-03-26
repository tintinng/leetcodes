package com.tintin.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelTraversal1{
    public static void main(String[] args) {
        TreeNode root = new Tree().getRoot();
        Soluton102 soluton102 = new Soluton102();
        System.out.println(soluton102.levelOrder(root));
    }
}

class Soluton102{
    public List<List<Integer>> levelOrder(TreeNode root) {
        //  队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 记录当前层数
        int level = 1;
        //存放结果
        List<List<Integer>> listList = new ArrayList<List<Integer>>();

        if(root==null){
            return listList;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            // list用于存储一层
            List<Integer> list = new ArrayList<Integer>();
            // 遍历一层
            int levelNum = queue.size();
            for(int i=0;i<levelNum;i++){
                TreeNode head = queue.remove();
                list.add(head.val);
                if(head.left!=null){
                    queue.add(head.left);
                }
                if(head.right!=null){
                    queue.add(head.right);
                }
            }
            // 添加本层list
            listList.add(list);
            // 下一层
            level++;
        }

        return listList;
    }
}
