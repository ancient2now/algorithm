package com.akikun.algorithm.sort;

import com.akikun.algorithm.common.PrintUtils;

import java.util.Arrays;

/**
 *
 * 基数排序（Radix Sort）
 *
 * @author Li Junqiu
 */
public class RadixSort {

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] arr = {3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321,10};
        radixSort.sort(arr);

        PrintUtils.printArray(arr);
    }

    public void sort(int[] arr) {
        int maxDigit = maxDigit(arr);
        int[] bucket = new int[10];
        int[] help = new int[arr.length];

        for (int i = 0; i < maxDigit; ++i) {

            for (int j = 0; j < arr.length; ++j) {
                int div = getDiv(arr[j], i);
                bucket[div] += 1;
            }

            preSum(bucket);

            for (int j = arr.length -1; j >=0; --j) {
                int div = getDiv(arr[j], i);
                help[--bucket[div]] = arr[j];
            }

            System.arraycopy(help, 0, arr, 0, arr.length);
            Arrays.fill(bucket, 0);
        }

    }

    private int maxDigit(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        int digit = 0;
        while (maxValue > 0) {
            maxValue = maxValue / 10;
            digit++;
        }
        return digit;
    }

    private int getDiv(int v, int i) {
        while (i > 0 && v > 0) {
            v /= 10;
            i--;
        }
        return v % 10;
    }

    private void preSum(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            arr[i] = arr[i] + arr[i-1];
        }
    }


}
