package com.akikun.algorithm.sort;

import com.akikun.algorithm.common.ArrayUtils;
import com.akikun.algorithm.common.PrintUtils;

import java.util.Arrays;

/**
 *
 * 堆排序 (Heap Sort)
 *
 * @author 李俊秋(龙泽)
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.randomRange(1000);
        int[] target = Arrays.copyOf(arr, arr.length);
//        PrintUtils.printArray(arr);

        new HeapSort().sort(arr);
        Arrays.sort(target);

        System.err.println(Arrays.equals(arr, target));
    }

    public void sort(int[] arr) {

        // O(N*logN)
//        for (int i = 0; i < arr.length; ++i) {
//            heapInsert(arr, i);
//        }

        // O(N)
        for (int i = arr.length - 1; i >= 0; --i) {
            heapify(arr, i, arr.length);
        }

        // O(N*logN)
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    private void heapify(int[] arr, int idx, int heapSize) {
        int left, right;
        while ((left = idx * 2 + 1) < heapSize) {
            right = left + 1;
            int largest = right < heapSize && arr[right] > arr[left] ? right : left;
            largest = arr[largest] > arr[idx] ? largest : idx;
            if (largest == idx) {
                break;
            }
            swap(arr, idx, largest);
            idx = largest;
        }
    }

    private void heapInsert(int[] arr, int idx) {
        for (int p; arr[idx] > arr[p = (idx - 1) / 2]; idx = p) {
            swap(arr, idx, p);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
