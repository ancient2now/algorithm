package com.akikun.leetcode.commons;

import com.akikun.algorithm.common.ListUtils;
import org.junit.Test;

import java.util.List;

public class ListTest {

    @Test
    public void testOf() {
        List<String> list = ListUtils.of("hello", "", "world");
        ListUtils.print(list);
    }

    @Test
    public void testFrom() {
        List<String> list = ListUtils.from("[\"cats\", \"dog\", \"sand\", \"and\", \"cat\", \"\"]");
        ListUtils.print(list);
    }
}
