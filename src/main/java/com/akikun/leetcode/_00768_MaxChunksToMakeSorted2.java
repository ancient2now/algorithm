package com.akikun.leetcode;

import java.util.Stack;

/**
 * @author 李俊秋(龙泽)
 */
public class _00768_MaxChunksToMakeSorted2 {

    /**
     * 题解2：
     */
    public int maxChunksToSorted(int[] arr) {
        
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int rightMax = stack.pop();

                while (!stack.isEmpty() && num < stack.peek()) {
                    stack.pop();
                }
                stack.push(rightMax);
            }

        }

        return stack.size();

    }
}
