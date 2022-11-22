package com.akikun.algorithm.common.struct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加强堆
 *
 * @author 李俊秋(龙泽)
 */
public class HeapGreater<T> {

    // TODO

    private List<T> heap;
    private Map<T, Integer> IdxMap;
    private int heapSize;
    private Comparator<T> comparator;

    public HeapGreater(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.IdxMap = new HashMap<>();
        this.heapSize = 0;
        this.comparator = comparator;
    }

    public void push(T e) {

    }

    public void remove(T e) {

    }

    /**
     * 刷新obj
     */
    public void resign(T obj) {

    }

    public T pop() {
        return null;
    }

    public T select() {
        return heap.get(0);
    }

}
