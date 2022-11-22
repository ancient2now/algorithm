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

    private final List<T> heap;
    private final Map<T, Integer> idxMap;
    private final Comparator<T> comparator;

    private int heapSize;

    public HeapGreater(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.idxMap = new HashMap<>();
        this.heapSize = 0;
        this.comparator = comparator;
    }

    public void push(T e) {
        heap.add(e);
        idxMap.put(e, heapSize++);
        heapInsert(heapSize - 1);
    }

    public void remove(T obj) {
        if (!idxMap.containsKey(obj)) {
            throw new IllegalArgumentException("Not Found " + obj);
        }
        Integer idx = idxMap.get(obj);
        swap(idx, --heapSize);
        heapify(idx);
        heap.remove(heapSize);
        idxMap.remove(obj);
    }

    /**
     * 刷新obj
     */
    public void resign(T obj) {
        if (!idxMap.containsKey(obj)) {
            throw new IllegalArgumentException("Not Found " + obj);
        }
        Integer idx = idxMap.get(obj);
        heapify(idx);
        heapInsert(idx);
    }

    public T pop() {
        T ans = heap.get(0);
        swap(0, --heapSize);
        heapify(0);
        heap.remove(heapSize);
        idxMap.remove(ans);
        return ans;
    }

    public T peek() {
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heapSize == 0 && idxMap.isEmpty();
    }

    public boolean contains(T obj) {
        return idxMap.containsKey(obj);
    }

    private void heapInsert(int idx) {
        int p = (idx - 1) / 2;
        while (compare(idx, p) < 0) {
            T t = heap.get(p);
            heap.set(p, heap.get(idx));
            heap.set(idx, t);

            idxMap.put(t, idx);
            idxMap.put(heap.get(p), p);

            idx = p;
            p = (idx - 1) / 2;
        }
    }

    private void heapify(int idx) {
        int left, right;
        while ((left = idx * 2 + 1) < heapSize) {
            right = left + 1;
            int mini = right < heapSize && compare(right, left) < 0
                    ? right : left;
            mini = compare(mini, idx) < 0 ? mini : idx;
            if (mini == idx) {
                break;
            }

            swap(mini, idx);
            idx = mini;
        }
    }

    private void swap(int a, int b) {
        T t = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, t);

        idxMap.put(t, b);
        idxMap.put(heap.get(a), a);
    }

    private int compare(int a, int b) {
        return comparator.compare(heap.get(a), heap.get(b));
    }

}
