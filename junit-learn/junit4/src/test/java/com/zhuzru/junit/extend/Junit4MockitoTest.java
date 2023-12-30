package com.zhuzru.junit.extend;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

/**
 * 功能描述：
 *
 * @Date 2023/12/16 16:16
 * @Created by zhuzru
 */
@RunWith(MockitoJUnitRunner.class)
public class Junit4MockitoTest {
    @Mock
    private List<String> list;

    @Test
    public void testList(){
        Mockito.when(list.add("Java")).thenReturn(true);
        Mockito.when(list.size()).thenReturn(10);

        Assert.assertEquals(10, list.size());
    }
}
