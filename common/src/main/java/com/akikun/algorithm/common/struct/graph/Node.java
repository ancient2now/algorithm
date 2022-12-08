package com.akikun.algorithm.common.struct.graph;

import java.util.ArrayList;

/**
 * 图节点描述
 *
 * @author 李俊秋(龙泽)
 */
public class Node {

    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
