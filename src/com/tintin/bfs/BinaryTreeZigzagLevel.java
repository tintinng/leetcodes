package com.tintin.bfs;

import java.util.*;

public class BinaryTreeZigzagLevel{
    public static void main(String[] args) {
        TreeNode root = new Tree().getRoot();
        Solution103 soluton103 = new Solution103();
        System.out.println(soluton103.zigzagLevelOrder(root));
    }
}

class Solution103{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if(root==null){
            return listList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 1;

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode head = queue.remove();
                list.add(head.val);
                if(head.left!=null){
                    queue.add(head.left);
                }
                if(head.right!=null){
                    queue.add(head.right);
                }
            }
            // 奇数层逆置
            if(level%2 == 0){
                Collections.reverse(list);
            }
            listList.add(list);
            level ++;
        }

        return listList;
    }
}
