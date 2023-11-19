package com.zhuzru.junit;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 通过继承TestCase运行test方法
 */
public class ExecuteTestByTestCase extends TestCase {
    private List<String> list;

    @Override
    protected void setUp() {
        list = new ArrayList<>(Arrays.asList("Java", "C++", "Python"));
        System.out.println("setUp!");
    }

    // 测试方法必须以test开头
    // junit2是基于java1.1及之后的版本开发的，未采用annotation来发起测试，因为annotation在jdk5中才出现
    // junit是从1995年开始开发，jdk是从1996年开始开发，所以junit最早开发时可能是和jdk同步开发，或者基于jdk内部版本进行开发。
    public void testElementShouldExisting() {
        // given
        String expected = "Java";
        // when
        boolean contains = list.contains(expected);
        // then
        assertTrue(contains);
        System.out.println("test!");
    }

    @Override
    protected void tearDown() {
        Assert.assertEquals(3, list.size());
        System.out.println("tearDown!");
    }
}
