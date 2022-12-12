package com.akikun.algorithm.common;

import org.junit.Test;

/**
 * @author 李俊秋(龙泽)
 */
public class TestArrayUtils {

    @Test
    public void testReadArray() {
        int[] ans = ArrayUtils.readArray("[3,4,5,5,78,8]");
        PrintUtils.printArray(ans);
    }

    @Test
    public void  testRead2dArray() {
        int[][] ans = ArrayUtils.read2dArray("[[1,4],[1,2],[2,1],[2,1],[3,2],[3,4]]");
        ArrayUtils.print2d(ans);
    }
}
