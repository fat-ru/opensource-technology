package com.zhuzru.junit.extend;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * 功能描述：
 *
 * @Date 2023/12/9 19:09
 * @Created by zhuzru
 */
@RunWith(Theories.class)
public class Junit4TheoriesTest {
    @DataPoints
    public static int[] data() {
        return new int[]{1, 2, 3};
    }

    @DataPoints
    public static int[] data1() {
        return new int[]{1, 10, 100};
    }

    @DataPoints
    public static int[] data2() {
        return new int[]{1, 10, 100};
    }

    @DataPoint
    public static int data = 4;

    @Theory
    public void doTestOneParam(int num) {
        System.out.println("num:" + num);
        Assert.assertTrue(num <= 100);
    }

    @Theory
    public void doTestTwoParams(int data1, int data2) {
        Assert.assertTrue(data1 < data1 + data2);
        System.out.println(String.format("data1:%d, data2:%d", data1, data2));
    }
}
