package com.akikun.algorithm.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintUtils {

    public static void printAnswer(Object o) {
        System.out.println("Answer: " + o.toString());
    }

    public static void printMatrix(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                sb.append(board[i][j]).append(',');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    public static <E> void printArray(E[] arr) {
        ArrayUtils.print(arr);
    }

    public static void printArray(int[] arr) {
        String arrStr = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.err.println("length:" + arr.length + "; values:" + arrStr);
    }

    public static void printArray(boolean[] arr) {
        int len = arr.length;
        if (len == 0) {
            System.err.println("length:" + len + "; values:[]");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            sb.append(",").append(arr[i]);
        }
        sb.deleteCharAt(0);
        System.err.println("length:" + len + "; values: [" + sb.toString() + "]" );
    }

    public static <E> void printList(List<E> list) {
        ListUtils.print(list);
    }
}
