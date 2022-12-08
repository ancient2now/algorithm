package com.akikun.algorithm.common.struct.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图数据结构
 *
 * @author 李俊秋(龙泽)
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
