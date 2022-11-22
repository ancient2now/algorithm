package com.akikun.algorithm.common;

import com.akikun.algorithm.common.struct.HeapGreater;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author 李俊秋(龙泽)
 */
public class TestHeapGreater {

    @Test
    public void test() {
        HeapGreater<Integer> heap = new HeapGreater<>(Comparator.comparingInt(a -> a));
        PriorityQueue<Integer> jdkHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        Random random = new Random();
        for (int i = 0; i < 1000; ++i) {
            int r = random.nextInt(1000);
            heap.push(r);
            jdkHeap.offer(r);
        }

        for (int i = 0; i < 1000; ++i) {
            Integer me = heap.pop();
            Integer he = jdkHeap.poll();
            Assert.assertEquals(me, he);
        }

        Assert.assertEquals(heap.isEmpty(), Boolean.TRUE);

    }
}
