package com.akikun.algorithm.sort;

import com.akikun.algorithm.common.ArrayUtils;
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
        int[] arr = ArrayUtils.randomRange(1000);
        int[] target = Arrays.copyOf(arr, arr.length);
//        PrintUtils.printArray(arr);

        new RadixSort().sort(arr);
        Arrays.sort(target);

        System.out.println(Arrays.equals(arr, target));
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
