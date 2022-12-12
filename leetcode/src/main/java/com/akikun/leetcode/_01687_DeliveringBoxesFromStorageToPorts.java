package com.akikun.leetcode;

import com.akikun.algorithm.common.ArrayUtils;
import java.util.LinkedList;

/**
 * @author 李俊秋(龙泽)
 */
public class _01687_DeliveringBoxesFromStorageToPorts {

    public static void main(String[] args) {
        _01687_DeliveringBoxesFromStorageToPorts slolution = new _01687_DeliveringBoxesFromStorageToPorts();

        int[][] boxes = ArrayUtils.read2dArray("[[1,4],[1,2],[2,1],[2,1],[3,2],[3,4]]");
//        int portsCount = 3; int maxBoxes = 6; int maxWeight = 7;  // expected: 6;
        int ans = slolution.boxDelivering(boxes, 3, 6, 7);
        System.out.println(ans);
    }

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        // 方式1： 递归解
//        int ans = process(boxes, boxes.length - 1, maxBoxes, maxWeight);

        // 方式二： 动态规划
//        int ans = dpProcess(boxes, portsCount, maxBoxes, maxWeight);

        // 方式三： 动态规划 + 滑动窗口优化
        int ans = dpWindowProcess(boxes, portsCount, maxBoxes, maxWeight);

        return ans;
    }

    private int process(int[][] boxes, int end, int maxBoxes, int maxWeight) {
        if (end < 0) {
            return 0;
        }

        int curWeight = 0;
        int curBoxes = 0;
        int cost = 0;
        int lastPort = -1;

        int ans = Integer.MAX_VALUE;
        for (int i = end; i >= 0 ; i--) {
            curBoxes ++;
            curWeight += boxes[i][1];

            if (curBoxes > maxBoxes || curWeight > maxWeight) {
                break;
            } else {
                if (boxes[i][0] != lastPort) {
                    cost++;
                    lastPort = boxes[i][0];
                }
                ans = Math.min(ans, cost + 1 + process(boxes, i - 1, maxBoxes, maxWeight));
            }
        }

        return ans;
    }

    private int dpProcess(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int[] map = new int[boxes.length + 1];
        for (int end = 1; end < boxes.length; ++end) {
            int curWeight = boxes[end - 1][1];
            int curBoxes = 1;
            int cost = 2;
            int lastPort = boxes[end - 1][0];

            int ans = 2 + map[end - 1];
            int idx = end - 1;
            while (curBoxes <= maxBoxes && curWeight <= maxWeight) {
                if (idx - 1 < 0) {
                    break;
                }
                if (boxes[idx - 1][0] != lastPort) {
                    cost++;
                    lastPort = boxes[idx - 1][0];
                }
                ans = Math.min(ans, cost + map[idx - 1]);
                curBoxes ++;
                curWeight += boxes[idx - 1][1];
            }
            map[end] = ans;
        }

        return map[boxes.length - 1];
    }

    // FIXME 动态规划 + 滑动窗口优化 没有实现，有点bug
    private int dpWindowProcess(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int[] map = new int[boxes.length + 1];

        int[] preSumWeight = new int[boxes.length + 1];
        for (int i = 1; i < preSumWeight.length; ++i) {
            preSumWeight[i] = preSumWeight[i - 1] + boxes[i - 1][1];
        }

        LinkedList<int[]> deque = new LinkedList<>();
        deque.add(new int[]{0, 0});
        for (int end = 1; end <= boxes.length; ++end) {
            int idx = end - 1;
            int diff = idx - 1 >= 0 && boxes[idx][0] != boxes[idx - 1][0] ? 1 : 0;
            int cost = 2 + map[idx];

            while (deque.peekLast()[1] > cost) {
                deque.pollLast();
            }
            deque.addLast(new int[]{end, cost});
            while (end - deque.peekFirst()[0] > maxBoxes
                || preSumWeight[end] - preSumWeight[deque.peekFirst()[0]] > maxWeight) {
                deque.pollFirst();
            }
            map[end]= 2 + deque.peekFirst()[1] + diff;
        }

        return map[boxes.length];
    }

}
