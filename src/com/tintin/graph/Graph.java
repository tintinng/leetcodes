package com.tintin.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tintin
 */
public class Graph {
    private List<String> vertexList;
    private int[][] edges;
    private int numOfEdges;

    public Graph(int n){
        this.edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    /**
     * 得到结点的个数
     * @return
     */
    public int getNumOfVertex(){
        return this.vertexList.size();
    }

    /**
     * 得到边的个数
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getVertexByIndex(int i){
        return this.vertexList.get(i);
    }

    /**
     * 获得边v1-v2的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }


}
