package com.zhuzru.junit.extend;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * 功能描述：
 *
 * @Date 2023/12/9 18:04
 * @Created by zhuzru
 */
@RunWith(Parameterized.class)
public class Junit4ParameterTest {
    @Parameterized.Parameter(0)
    public String str;

    @Parameterized.Parameter(1)
    public int length;

    @Parameterized.Parameters(name = "{index} <===> str={0}  length={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{"Junit", 5}, {"Java", 4}, {"Jupiter", 7}});
    }

    @Test
    public void testStrLength() {
        Assert.assertEquals(length, str.length());
    }
}
