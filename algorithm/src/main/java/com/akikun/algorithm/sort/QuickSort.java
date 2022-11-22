package com.akikun.algorithm.sort;

import com.akikun.algorithm.common.ArrayUtils;
import com.akikun.algorithm.common.PrintUtils;

import java.util.Arrays;

/**
 *
 * 快速排序（Quick Sort）
 *
 * @author Li Junqiu
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.randomRange(1000);
        int[] target = Arrays.copyOf(arr, arr.length);

        new QuickSort().quickSort(arr);
        Arrays.sort(target);

        System.err.println(Arrays.equals(arr, target));
    }

    public void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void qSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int a = start, b = end;
        while (a < b) {
            while (arr[b] > pivot && a < b) {
                b--;
            }
            while (arr[a] < pivot && a < b) {
                a++;
            }

            if (arr[a] == arr[b] && a < b) {
                a++;
            } else {
                swap(arr, a, b);
            }

            if (a - 1 > start) {
                qSort(arr, start, a - 1);
            }
            if (b + 1 < end) {
                qSort(arr, b + 1, end);
            }
        }
    }
}
