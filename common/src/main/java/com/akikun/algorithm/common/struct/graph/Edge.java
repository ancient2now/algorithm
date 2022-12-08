package com.akikun.algorithm.common.struct.graph;

/**
 * 图边描述
 *
 * @author 李俊秋(龙泽)
 */
public class Edge {

    Node from;
    Node to;
    int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

}
