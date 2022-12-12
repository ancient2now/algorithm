package com.akikun.algorithm.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayUtils {

    /**
     * 打印数组
     * @param arr 数组
     * @param <E> 数组元素的类型
     */
    public static <E> void print(E[] arr) {
        String arrStr = Arrays.stream(arr)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("length:" + arr.length + "; values:" + arrStr);
    }

    public static <E> void print2d(E[][] arr2d) {
        StringBuilder sb = new StringBuilder("[\n");
        for (E[] arr : arr2d) {
            sb.append("\t");
            String lineStr = Arrays.stream(arr)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));

            sb.append(lineStr);
            sb.append("\n");
        }
        sb.append("]");

        System.out.println( "二维数组：\n" + sb.toString());
    }

    public static void print2d(int[][] arr2d) {
        StringBuilder sb = new StringBuilder("高：").append(arr2d.length);

        if (arr2d.length == 0) {
            System.out.println("[]");
            return;
        }

        sb.append("宽：").append(arr2d[0].length);

        sb.append("[\n");
        for (int[] arr : arr2d) {
            sb.append("\t");
            String lineStr = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));

            sb.append(lineStr);
            sb.append("\n");
        }
        sb.append("]");

        System.out.println(sb.toString());
    }

    /**
     * 将int数组转化成Integer类型的List
     * @param arr int数组
     * @return Integer列表
     */
    public static List<Integer> toList(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * 随机生成素组, 数组的值都是随机整数
     * @param len 数组的长度
     * @return 一个随机生成的数组
     */
    public static int[] random(int len) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; ++i) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    public static int[] randomPositive(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; ++i) {
            arr[i] = (int) ((Math.random() * 9 + 1) * 10000000);
        }
        return arr;
    }

    /**
     * 随机生成素组, 数组的值都是随机整数
     * @param len 数组的长度
     * @param round 随机数的大小范围
     * @return 一个随机生成的数组
     */
    public static int[] random(int len, int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("round must be positive");
        }

        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; ++i) {
            arr[i] = random.nextInt(round);
        }
        return arr;
    }

    public static int[] randomRange(int len) {
        if (len <= 0) {
            throw new IllegalArgumentException("len must be positive");
        }

        int[] arr = new int[len];
        for (int i = 0; i < len; ++i) {
            arr[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < len; ++i) {
            int a = random.nextInt(len);
            int b = random.nextInt(len);

            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        return arr;
    }

    public static int[] readArray(String str) {
        if (str == null || str.length() == 0) {
            return new int[]{};
        }

        str = str.substring(1, str.length() - 1);
        if (str.length() == 0) {
            return new int[]{};
        }

        String[] split = str.split(",");
        int[] ans = new int[split.length];
        for (int i = 0; i < split.length; ++i) {
            ans[i] = Integer.parseInt(split[i]);
        }

        return ans;
    }

    /**
     *
     * 将字符串转化为二维数组
     *
     * @param str "[[1,4],[1,2],[2,1],[2,1],[3,2],[3,4]]"
     * @return new int[][] {{1,4}, {1,2}, {2,1}, {2,1}, {3,2}, {3,4}}
     */
    public static int[][] read2dArray(String str) {
        if (str == null || str.length() == 0) {
            return new int[][]{};
        }

        str = str.substring(1, str.length() - 1);
        if (str.length() == 0) {
            return new int[][]{};
        }

        char[] chas = str.toCharArray();

        List<int[]> list = new LinkedList<>();

        int W = 0;
        for (int L = 0, R = 0;R < chas.length;) {
            while (R < chas.length && chas[R] != ']') {
                R++;
            }
            while (L < chas.length && chas[L] != '[') {
                L++;
            }

            String one = str.substring(++L, R++);

            String[] split = one.split(",");
            int[] arr = new int[split.length];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = Integer.parseInt(split[i]);
            }

            W = Math.max(W, arr.length);
            list.add(arr);
        }

        int H = list.size();

        int[][] ans = new int[H][W];
        for (int i = 0; i < H; ++i) {
            int[] line = list.get(i);
            for (int j = 0; j < W; ++j) {
                ans[i][j] = line[j];
            }
        }

        return ans;

    }

}
