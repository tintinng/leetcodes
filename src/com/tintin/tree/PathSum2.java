package com.tintin.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2{
    public static void main(String[] args) {
        Tree tree = new Tree(new String[]{"5","4","8","11","null","13","4","7","2","null","null","null","null","5","1"});
        int sum = 22;
        System.out.println(new Solution113().pathSum(tree.getRoot(),sum));
    }
}

class Solution113{
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return lists;
        }
        preOrder(root,new ArrayList<>(),0,sum);

        return lists;
    }

    public void preOrder(TreeNode root,List<Integer> path,int curSum, int sum){
        curSum += root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(curSum==sum){
                // 不能加入原来的list
                lists.add(new ArrayList<>(path));
            }
            curSum -= root.val;
            // 叶子节点遍历后从path中去掉
            // 遇到相同的val，要删除后一个加入的val；因为后加入的val为前加入val的子孙
            path.remove(path.lastIndexOf(root.val));
            return;
        }
        if(root.left!=null){
            preOrder(root.left,path,curSum,sum);
        }
        if(root.right!=null){
            preOrder(root.right,path,curSum,sum);
        }
        // 从路径中去掉中间节点
        path.remove(path.lastIndexOf(root.val));
    }
}