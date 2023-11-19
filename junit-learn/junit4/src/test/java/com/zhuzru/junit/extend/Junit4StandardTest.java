package com.zhuzru.junit.extend;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述：
 *
 * @Date 2023/11/19 18:09
 * @Created by zhuzru
 */
public class Junit4StandardTest {
    private static List<String> classList;
    private List<String> instanceList;

    @BeforeClass
    public static void init(){
        classList = new ArrayList<>(Collections.singletonList("JAVA"));
        System.out.println("init!");
    }

    @Before
    public void setUp(){
        instanceList = new ArrayList<>(Collections.singletonList("java"));
        System.out.println("setUp!");
    }

    @Test
    public void test(){
        Assert.assertTrue(classList.contains("JAVA"));
        Assert.assertTrue(instanceList.contains("java"));
        System.out.println("test!");
    }

    @After
    public void tearDown(){
        Assert.assertEquals(1, instanceList.size());
        instanceList.clear();
        System.out.println("tearDown!");
    }

    @AfterClass
    public static void destroy(){
        Assert.assertEquals(1,classList.size());
        classList.clear();
        System.out.println("destroy!");
    }
}
