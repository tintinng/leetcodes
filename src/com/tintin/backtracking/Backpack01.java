package com.tintin.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 0-1 背包问题有很多变体，我这里介绍一种比较基础的。
 * 我们有一个背包，背包总的承载重量是 Wkg。现在我们有
 * n 个物品，每个物品的重量不等，并且不可分割。我们现在
 * 期望选择几件物品，装载到背包中。在不超过背包所能装载重
 * 量的前提下，如何让背包中物品的总重量最大？
 */
public class Backpack01{
    public static void main(String[] args) {
        int[] weights = new int[]{3,2};
        Backpack backpack = new Backpack(14,weights);
        System.out.println(backpack.getCurWeight());
        backpack.backtrack(-1);
        System.out.println(backpack.getCurWeight());
    }
}

/**
 * 1、路径：背包所包含的物品
 * 2、选择列表：剩余的所有没有装进背包的物品
 * 3、结束条件：装入物品后超过背包最大重量
 */
class Backpack{

    /**
     * 可以选到的最大重量
     */
    private int curWeight;
    /**
     * 背包可装载最大重量
     */
    private int maxWeight;
    /**
     * 物品的重量列表
     */
    private int[] weights;
    /**
     * 当前背包装载的物品编号
     */
    private List<Integer> bag;

    public Backpack(){}

    public Backpack(int weight,int[] weights){
        this.maxWeight = weight;
        this.weights = weights;
        this.curWeight = 0;
        this.bag = new ArrayList<>();
    }

    public void backtrack(int w){
        if(calculateWeight(bag) > maxWeight){
            return;
        }
        curWeight = Math.max(calculateWeight(bag),curWeight);
        for(int i=0;i<weights.length;i++){
            if(bag.contains(i)){
                continue;
            }
            bag.add(i);
            backtrack(i);
            bag.remove((Integer) i);
        }
    }

    /**
     * 计算背包当前的重量
     * @param bag
     * @return
     */
    private int calculateWeight(List<Integer> bag){
        int bagWeight = 0;
        for (Integer li:bag) {
            bagWeight += weights[li];
        }
        return bagWeight;
    }

    public int getCurWeight() {
        return curWeight;
    }
}
