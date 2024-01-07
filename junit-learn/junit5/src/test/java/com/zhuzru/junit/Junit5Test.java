package com.zhuzru.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class Junit5Test {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void listShouldContainsElement() {
        final List<String> list = new ArrayList<>(Arrays.asList("JAVA","Junit5", "Jupiter"));
        final String element = "JAVA";
        Assertions.assertTrue(list.contains(element));
    }
}
