package com.zhuzru.junit.extend;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

/**
 * 功能描述：
 *
 * @Date 2023/11/19 21:47
 * @Created by zhuzru
 */
@RunWith(Theories.class)
public class JunitRuleTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private List<String> list;

    @DataPoints
    public static int[] data1() {
        return new int[]{1, 10, 100};
    }

    @DataPoints
    public static int[] data2() {
        return new int[]{1, 10, 100};
    }

    @Theory
    public void test(int data1, int data2) {
        Assert.assertTrue(data1 < data1 + data2);
        System.out.println(String.format("data1:%d, data2:%d", data1, data2));
    }

    @Test
    public void testList() {
        Mockito.when(list.add("Java")).thenReturn(true);
        Mockito.when(list.size()).thenReturn(10);

        Assert.assertEquals(10, list.size());
    }
}
